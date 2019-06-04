from tokenize import String

import bs4
import os
import sys
import requests
from sqlalchemy import create_engine, ForeignKey, Column, Integer
from sqlalchemy import Column, ForeignKey, Integer, String
from sqlalchemy.orm import sessionmaker, relationship
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

class Studiji(Model):
    __tablename__='studiji'
    id=Column(Integer, primary_key=True)
    naziv= Column(String(250),nullable=False)
    godina= Column(Integer,nullable=False)
    url = Column(String(250), nullable=False)

class Termin(Model):
    __tablename__ = 'termini'
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column('title', db.String(32))
    date = db.Column('date', db.DateTime)
    startTime= db.Column('startTime', db.Integer)
    duration = db.Column('duration', db.Float)
    studiji_id=  Column(Integer, ForeignKey('studiji.id'))
    person = relationship(Studiji)


Model.metadata.create_all(engine)

session.query(Studiji).delete()
studij = Studiji()
studij.naziv  = "Racunarstvo"
studij.godina = 1
studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar1/calendar?ShowSysMessages=true&urlencUTF8=true"
session.add(studij)
session.commit()



res = requests.get(studij.url)
soup = bs4.BeautifulSoup(res.text, 'html.parser')



divs = soup.select('.appointment > div.h4 > span')
styles = soup.select('.appointment[style]')
scripts = soup.select('script')
lines = scripts[18].string.split("\n")
appointments = {}
for idx, line in enumerate(lines):
    if line.startswith("FActivityArray") and "[\"id\"]" in line:
        id = line.replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")

        startDateTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        starTime= lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "").split(',')[1]
        endDateTime = lines[idx+4].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        startDateTime = datetime.strptime(startDateTime, "%Y-%m-%d,%H:%M:%S")
        endDateTime = datetime.strptime(endDateTime, "%Y-%m-%d,%H:%M:%S")

        appointments[id] = {
            'id': id,
            'date': startDateTime,
            'duration': float((endDateTime-startDateTime).seconds/60/60),
            'startTime': starTime,
            'studiji.id': studij.godina
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
    termin.startTime = appointment['startTime']
    termin.studiji_id= studij.id
    session.add(termin)
    session.commit()


##_________________________________________________________________________________________________________


studij = Studiji()
studij.naziv  = "Racunarstvo"
studij.godina = 2
studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar2/calendar?ShowSysMessages=true&urlencUTF8=true"
session.add(studij)
session.commit()



res = requests.get(studij.url)
soup = bs4.BeautifulSoup(res.text, 'html.parser')



divs = soup.select('.appointment > div.h4 > span')
styles = soup.select('.appointment[style]')
scripts = soup.select('script')
lines = scripts[18].string.split("\n")
appointments = {}
for idx, line in enumerate(lines):
    if line.startswith("FActivityArray") and "[\"id\"]" in line:
        id = line.replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")

        startDateTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        starTime= lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "").split(',')[1]
        endDateTime = lines[idx+4].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "")
        startDateTime = datetime.strptime(startDateTime, "%Y-%m-%d,%H:%M:%S")
        endDateTime = datetime.strptime(endDateTime, "%Y-%m-%d,%H:%M:%S")

        appointments[id] = {
            'id': id,
            'date': startDateTime,
            'duration': float((endDateTime-startDateTime).seconds/60/60),
            'startTime': starTime,
            'studiji.id': studij.godina
        }




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
    termin.startTime = appointment['startTime']
    termin.studiji_id= studij.id
    session.add(termin)
    session.commit()



divs = soup.select('.appointment[style]')


for div in divs:
    style = {}
    for attr in div['style'].split(";"):
       if (len(attr.split(":")) == 2):
          key, value = attr.split(":")
          style[key] = value



