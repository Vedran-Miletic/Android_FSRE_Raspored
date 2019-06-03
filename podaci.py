import bs4
import requests
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
import sqlalchemy as db
from datetime import datetime


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
    date = db.Column('date', db.Date)
    duration = db.Column('duration', db.Integer)

Model.metadata.create_all(engine)




res = requests.get('http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar1/calendar?ShowSysMessages=true&urlencUTF8=true')
soup = bs4.BeautifulSoup(res.text, 'html.parser')
#elem_len = len(soup.select('.appointment > div.h4 > span'))
#for i in range(0, elem_len):
    #termin = Termin()
    #termin.title = soup.select('.appointment > div.h4 > span')[i].text
    #termin.date = datetime.now()
    #session.add(termin)
    #session.commit()

divs = soup.select('.appointment[style]')


for div in divs:
    style = {}
    for attr in div['style'].split(";"):
       if (len(attr.split(":")) == 2):
          key, value = attr.split(":")
          style[key] = value
    #START TIME print(round(int([style[" top"][i:i+3] for i in range(0, len(style[" top"]), 3)][0])/30, 1))
    #termin = Termin()
    #termin.duration = round(int([style[" height"][i:i+2] for i in range(0, len(style[" height"]), 2)][0])/30)
    #session.execute('update(termini, values={duration: termin.duration})')
    #session.commit()


for i in soup.select('.colHeadLink > span'):
    print(i.text)



