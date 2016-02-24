Create Table COURSE_DETAILS_RECORD(
CID NUMBER(10),
CNAME VARCHAR2(20),
CAUTHOR VARCHAR2(20),
COURSEFILENAME VARCHAR2(60),
File_Extension VARCHAR2(20),
Min_Duration VARCHAR2(20),
A_TL_EL VARCHAR(20),
A_TL_PO VARCHAR2(20),
A_TL_AD VARCHAR2(20),
A_TL_AS VARCHAR2(20),
A_TM_EL VARCHAR2(20),
A_TM_PO VARCHAR2(20),
A_TM_AD VARCHAR2(20),
A_TM_AS VARCHAR2(20),
M_TL_EL VARCHAR(20),
M_TL_PO VARCHAR2(20),
M_TL_AD VARCHAR2(20),
M_TL_AS VARCHAR2(20),
M_TM_EL VARCHAR2(20),
M_TM_PO VARCHAR2(20),
M_TM_AD VARCHAR2(20),
M_TM_AS VARCHAR2(20),
DM VARCHAR2(20),
COURSEDATE date,
CONSTRAINT COURSE_DETAILS_RECORDS_ID PRIMARY KEY (CID) );




Create Table CoursePicture_RECORD(
CourseID number(10) not null,
picture BLOB not null,
Picture_Count Number(10) not null,
Picture_Id number(10),
Course_Picture  date,
CONSTRAINT PICTURE_ID_RECORD PRIMARY KEY (Picture_Id),
 CONSTRAINT fkcourse_Record
    FOREIGN KEY (CourseID)
    REFERENCES COURSE_DETAILS_RECORD(CID)
	ON DELETE CASCADE);
	
	  CREATE SEQUENCE PICTURE_ID
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

  
  CREATE SEQUENCE COURSE_ID
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
	
	
	
	
	CREATE SEQUENCE Reg_Id 
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  


  

  
 CREATE TABLE TRAINING_TOOL_USERS
  (
    userid         NUMBER(11) NOT NULL ,
    name           VARCHAR(45) DEFAULT NULL,
    email          VARCHAR(100) Unique,
    password       VARCHAR(200) not null,
    User_Role      VARCHAR2(20),
    registereddate DATE,
    authorized     VARCHAR2(50),
    User_Sub_Role      VARCHAR2(20),
    PRIMARY KEY (userid)
  );
  
  ALTER TABLE TRAINING_TOOL_USERS ADD profile_pic blob;
  
CREATE SEQUENCE USERS_ID
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
 
CREATE Table Visit_Course_Details(
Course_Id varchar2(20),
current_page varchar2(20),
user_namea varchar2(20)
);

**************************** Assesments *****************************
CREATE TABLE Assesments
  (
    Ass_Id         NUMBER(10),
    questionNumber NUMBER(10),
    question       VARCHAR2(1000),
    answerOne      VARCHAR2(1000) ,
    answerTwo      VARCHAR2(1000),
    answerThree    VARCHAR2(1000),
    answerFour     VARCHAR2(1000),
    correctAnswer  NUMBER(10),
    Ass_time number(10)
  );
  
  
   CREATE SEQUENCE Ass_Id
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  create Table ResultRecord(
    rid number(10),
    userId varchar2(20),
    userName varchar2(100),
    userRole varchar2(200),
    status varchar2(200),
    marks number(10),
    cid number(10),
    noOfAttempt number(10),
    resdate date
    );
    ALTER TABLE ResultRecord ADD userSubRole varchar2(20);

      CREATE SEQUENCE Res_Id
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
    Create Table FIle_One_Data(
   userid         NUMBER(11) NOT NULL ,
    name           VARCHAR(45) DEFAULT NULL,
    email          VARCHAR(100) Unique,
    password       VARCHAR(200) not null,
    User_Role      VARCHAR2(20),
    registereddate DATE,
    authorized     VARCHAR2(50),
    User_Sub_Role      VARCHAR2(20),
    PRIMARY KEY (userid)
  
  );
  
  CREATE SEQUENCE USERS_ID_FILE_ONE
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  
  
  ALTER DATABASE
 DATAFILE 'C:/oraclexe/oradata/XE/system.dbf'
RESIZE 2048M;