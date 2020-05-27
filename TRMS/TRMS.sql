/*******************************************************************************
   Tuition Reimbursement Management System (TRMS) Database - Version 1.0
   Script: TRMS.sql
   Description: Creates the TRMS database.
   DB Server: Oracle
   Author: Anas Mohamad Daud
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/

DROP USER TRMS CASCADE;

/*******************************************************************************
   Create Database
********************************************************************************/
CREATE USER amd
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to amd;
GRANT resource to amd;
GRANT create session TO amd;
GRANT create table TO amd;
GRANT create view TO amd;

conn amd/p4ssw0rd

/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE USERS(
USER_ID INTEGER PRIMARY KEY,
USER_NAME VARCHAR2(20),
USER_PASSWORD VARCHAR2(20),
FIRST_NAME VARCHAR2(20),
LAST_NAME VARCHAR2(20),
USER_POS VARCHAR2(20),
ACC_BALANCE DOUBLE PRECISION);

INSERT INTO USERS VALUES(1,'anasd','password','Anas','Daud','Employee',1000);
INSERT INTO USERS VALUES(2,'bgates','password','Bill','Gates','DS',1000);
INSERT INTO USERS VALUES(3,'testdh','password','Department','Head','DH',1000);
INSERT INTO USERS VALUES(4,'testbenco','password','Ben','Co','BC',1000);


CREATE TABLE FORMS(
R_ID INTEGER PRIMARY KEY,
USER_NAME VARCHAR2(20),
SUBMISSION_DATE DATE,
COURSE_START_DATE DATE,
COURSE_END_DATE DATE,
EVENT_TYPE VARCHAR(20),
LOCATION VARCHAR2(20),
COURSE_COST DOUBLE PRECISION,
GRADE_FORMAT VARCHAR(20),
PASSING_GRADE VARCHAR(20),
PMT_LEFT INTEGER,
OFFER_STAT VARCHAR2(20));

/*******************************************************************************
   CREATE SEQUENCES
********************************************************************************/

CREATE SEQUENCE USERSEQ;
CREATE SEQUENCE FORMSEQ; 

/*******************************************************************************
   Alter Tables
********************************************************************************/

ALTER TABLE CUSTOMERS
ADD CONSTRAINT UQ_USER_NAME
UNIQUE(USER_NAME);

/*******************************************************************************
   Procedures
********************************************************************************/



