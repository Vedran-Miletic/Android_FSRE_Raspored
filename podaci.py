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
session.query(Termin).delete()


#RAČUNARSTVO
for i in range(1, 9):
    if i == 6:
        continue
    studij = Studiji()
    if i == 1 or i == 2 or i == 3:
        studij.naziv = "Racunarstvo"
    else:
        studij.naziv = "Racunarstvo - Diplomski"
    studij.godina = i
    studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar"+str(i)+"/calendar?ShowSysMessages=true&urlencUTF8=true"
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
            starTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "").split(',')[1]
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
        termin.studiji_id = studij.id
        session.add(termin)
        session.commit()

#ELEKTROTEHNIKA

for i in range(0, 3):
    studij = Studiji()
    studij.naziv = "Elektrotehnika"
    studij.godina = i + 1
    if i < 1:
        studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar44/calendar?"
    else:
        studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar44/calendar"+str(i)+"?"
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
            starTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "").split(',')[1]
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
        termin.studiji_id = studij.id
        session.add(termin)
        session.commit()

#STROJARSTVO

for i in range(6, 29):
    if i > 6 and i < 16 or i == 19 or i == 23 or i == 27:
        continue

    studij = Studiji()
    if i == 6 or i == 16 or i == 17 or i == 18 or i == 20:
        studij.naziv = "Strojarstvo"
    else:
        studij.naziv = "Strojarstvo - Diplomski"
    studij.godina = i
    studij.url = "http://intranet.fsre.sum.ba:81/intranetfsr/teamworks.dll/calendar/calendar"+str(i)+"/calendar?"
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
            starTime = lines[idx+5].replace(";", "").split(" = ")[1].replace("\"", "").replace("\r", "").split(',')[1]
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
        termin.studiji_id = studij.id
        session.add(termin)
        session.commit()

