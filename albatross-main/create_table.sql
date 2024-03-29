CREATE SEQUENCE SEQ_USER;
DROP SEQUENCE SEQ_USER;

CREATE TABLE ATT_USER(
	UUID NUMBER(10) PRIMARY KEY,
	MAIL VARCHAR2(200) NOT NULL,
	PASSWORD VARCHAR2(50) NOT NULL,
	NICKNAME VARCHAR2(50) NOT NULL,
	INTRO VARCHAR2(1000) NOT NULL,
	AUTHORITY VARCHAR2(50) NOT NULL,
	ENABLED CHAR(1) DEFAULT '1',
	PROFILE_LINK VARCHAR2(1000),
	JOINDATE DATE DEFAULT SYSDATE
);

INSERT INTO ATT_USER(UUID, MAIL, PASSWORD, NICKNAME, INTRO, AUTHORITY, PROFILE_LINK, JOINDATE)
VALUES(SEQ_USER.NEXTVAL, 'hansamkang@naver.com', 'sam4001!@#', '한샘', '강한샘입니다. 잘부탁드립니다.', 'ROLE_USER', 'none', SYSDATE);

INSERT INTO ATT_USER(UUID, MAIL, PASSWORD, NICKNAME, INTRO, AUTHORITY, PROFILE_LINK, JOINDATE)
VALUES(SEQ_USER.NEXTVAL, 'hansamkang@hanmail.net', '123123', '그림자분신', '카게분신 강한샘', 'ROLE_ADMIN', 'none', SYSDATE);

DELETE FROM ATT_USER WHERE UUID=50;

DROP TABLE ATT_USER;

UPDATE ATT_USER
SET PROFILE_LINK =NULL 
WHERE UUID = 4;

SELECT * FROM ATT_USER ORDER BY UUID;

DROP SEQUENCE SEQ_TWEET;

CREATE SEQUENCE SEQ_TWEET

CREATE TABLE ATT_TWEET(
	TID NUMBER(10) PRIMARY KEY,
	UUID NUMBER(10),
	T_TYPE VARCHAR2(20) DEFAULT 'nomal',
	REF_TID NUMBER(10),
	CONTENT VARCHAR2(1000) NOT NULL,
	IMAGE_LINK VARCHAR2(1000),
	REGDATE DATE DEFAULT SYSDATE,
	UPDATEDATE DATE DEFAULT SYSDATE,
	CONSTRAINT FK_TWEET_UUID FOREIGN KEY(UUID)
	REFERENCES ATT_USER(UUID)
);

INSERT INTO ATT_TWEET(TID, UUID, CONTENT, REGDATE, UPDATEDATE)
VALUES(SEQ_TWEET.NEXTVAL, 3, '첫번쨰 트윗', SYSDATE, SYSDATE);
DELETE FROM ATT_TWEET WHERE TID=26;

DROP TABLE ATT_TWEET;

SELECT * FROM ATT_TWEET ORDER BY TID;
COMMIT;




CREATE SEQUENCE SEQ_FOLLOW;
DROP SEQUENCE SEQ_FOLLOW;

CREATE TABLE ATT_FOLLOW(
	FID NUMBER(10) PRIMARY KEY,
	FROM_UID NUMBER(10),
	TO_UID NUMBER(10),
	FOLLOWDATE DATE DEFAULT SYSDATE,
	CONSTRAINT FK_FROM_UID FOREIGN KEY(FROM_UID) REFERENCES ATT_USER(UUID),
	CONSTRAINT FK_TO_UID FOREIGN KEY(TO_UID) REFERENCES ATT_USER(UUID)
);

INSERT INTO ATT_FOLLOW(FID, FROM_UID, TO_UID, FOLLOWDATE)
VALUES(SEQ_FOLLOW.NEXTVAL, 3, 4, SYSDATE);




CREATE SEQUENCE SEQ_HEART;
DROP SEQUENCE SEQ_HEART;

CREATE TABLE ATT_HEART (
    HID NUMBER(10) PRIMARY KEY,
    UUID NUMBER(10),
    TID NUMBER(10),
    HEARTDATE DATE DEFAULT SYSDATE,
    CONSTRAINT FK_HEART_UID FOREIGN KEY(UUID) REFERENCES ATT_USER(UUID),
	CONSTRAINT FK_HEART_TID FOREIGN KEY(TID) REFERENCES ATT_TWEET(TID)
);

DROP TABLE ATT_HEART;

INSERT INTO ATT_HEART(HID, UUID, TID, HEARTDATE)
VALUES(SEQ_HEART.NEXTVAL, 3, 109, SYSDATE);

DELETE FROM ATT_HEART WHERE HID = 24;





CREATE TABLE DECLARE_TBL(
   DID NUMBER PRIMARY KEY,
   TID NUMBER NOT NULL,      
   UUID NUMBER(10) NOT NULL,
   CONSTRAINT FK_DECLARE_TID FOREIGN KEY(TID)
      REFERENCES ATT_TWEET(TID),
   CONSTRAINT FK_DECLARE_UUID FOREIGN KEY(UUID)
      REFERENCES ATT_USER(UUID)
);

CREATE SEQUENCE SEQ_DECLARE;

INSERT INTO DECLARE_TBL(DID,TID,UUID)
VALUES(SEQ_DECLARE.NEXTVAL, 121, 3);


SELECT * FROM ATT_USER ORDER BY UUID;
SELECT * FROM ATT_TWEET ORDER BY TID DESC;
SELECT * FROM ATT_FOLLOW ORDER BY FID;
SELECT * FROM ATT_HEART ORDER BY HID;
SELECT * FROM DECLARE_TBL ORDER BY DID;