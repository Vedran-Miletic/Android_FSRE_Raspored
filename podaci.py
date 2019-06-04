import bs4
import requests
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
import sqlalchemy as db
from datetime import datetime
import re

Model = declarative_base()

# create an engine
engine = create_engine('sqlite:///baza.db')

Model.metadata.bind = engine
# create a configured "Session" class
Session = sessionmaker(bind=engine)

# create a Session
session = Session()


class Termin(Model):
    __tablename__ = 'termini'
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column('title', db.String(32))
    date = db.Column('date', db.DateTime)
    duration = db.Column('duration', db.Integer)

Model.metadata.create_all(engine)




res = requests.get('http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar1/calendar?ShowSysMessages=true&urlencUTF8=true')
soup = bs4.BeautifulSoup(res.text, 'html.parser')

#for i in range(0, elem_len):
#    termin = Termin()
#    termin.title = soup.select('.appointment > div.h4 > span')[i].text
#    termin.date = datetime.now()
#    session.add(termin)
#    session.commit()
divs = soup.select('.appointment > div.h4 > span')
styles = soup.select('.appointment[style]')
scripts = soup.select('script')
lines = scripts[18].string.split("\n")
appointments = {}
for idx, line in enumerate(lines):
    if line.startswith("FActivityArray") and "[\"id\"]" in line:
        id = line.replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")

        startDateTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        endDateTime = lines[idx+4].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        startDateTime = datetime.strptime(startDateTime, "%Y-%m-%d,%H:%M:%S")
        endDateTime = datetime.strptime(endDateTime, "%Y-%m-%d,%H:%M:%S")

        appointments[id] = {
            'id': id,
            'date': startDateTime,
            'duration': int((endDateTime-startDateTime).seconds/60/60)
        }


session.query(Termin).delete()

for id, div in enumerate(divs):
    style = {}
    for attr in styles[id]['style'].split(";"):
       if (len(attr.split(":")) == 2):
          key, value = attr.split(":")
          style[key] = value
    termin = Termin()
    appointment = appointments[divs[id]['id'].replace("_vertraulich", "")]
    termin.title = divs[id].text
    termin.date = appointment['date']
    termin.duration = appointment['duration']

    session.add(termin)
    session.commit()



#Dohvat dana u tjednu
#for i in soup.select('.colHeadLink > span'):
    #print(i.text)

#update = session.query(Termin).filter_by(id=1).first()
#update.duration = 5
#session.commit()


