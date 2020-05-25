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

CREATE TABLE REQUESTS(
REQUEST_ID INTEGER PRIMARY KEY,
USER VARCHAR2(20),
CAR_ID INTEGER,
CAR_PRICE DOUBLE PRECISION,
DWN_PMT DOUBLE PRECISION,
MNTHLY_PMT DOUBLE PRECISION,
PMT_LEFT INTEGER,
OFFER_STAT VARCHAR2(20));

/*******************************************************************************
   CREATE SEQUENCES
********************************************************************************/

CREATE SEQUENCE USERSEQ;
CREATE SEQUENCE CARSEQ;
CREATE SEQUENCE OFFERSEQ; 

/*******************************************************************************
   Alter Tables
********************************************************************************/

ALTER TABLE CUSTOMERS
ADD CONSTRAINT UQ_USER_NAME
UNIQUE(USER_NAME);

/*******************************************************************************
   Procedures
********************************************************************************/



