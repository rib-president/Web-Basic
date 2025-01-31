SELECT * FROM DEPT01;
DROP TABLE DEPT01;

DESC DEPT;

CREATE TABLE DEPT01
AS
SELECT * FROM DEPT;

DESC DEPT01;

--1.PRIMARY KEY의 NOT NULL 제약조건 확인
INSERT INTO DEPT
VALUES(10, 'TEST', 'SEOUL');    --에러발생

SELECT * FROM DEPT;

INSERT INTO DEPT
VALUES(NULL, 'TEST', 'SEOUL');  --에러발생

--USER_CONSTRAINTS (ALL_CONSTRAINTS, DBA_CONSTRAINTS VIEW TABLE도 존재함)
DESC USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

DESC DEPT01;

--DEPT01 DEPTNO는 PRIMARY KEY 지정되어 있지 않음
INSERT INTO DEPT01
VALUES(10, 'TEST', 'SEOUL');

INSERT INTO DEPT01
VALUES(NULL, 'TEST', 'SEOUL');

SELECT * FROM DEPT01;

--EMP01 : EMPNO, ENAME에 대해 NOT NULL 제약조건 설정
CREATE TABLE EMP01(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2)
);

INSERT INTO EMP01
VALUES(NULL, NULL, 'SALESMANE', 10);

INSERT INTO EMP01
VALUES(NULL, 'SCOTT', 'SALESMANE', 10);

INSERT INTO EMP01
VALUES(7499, 'ALLEN', 'SALESMANE', 10);

INSERT INTO EMP01
VALUES(7499, 'SCOTT', 'MANAGER', 20);

SELECT * FROM EMP01;

--UNIQUE 실습
DROP TABLE EMP03;

CREATE TABLE EMP03(
    EMPNO NUMBER(4) UNIQUE,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2)
);

DESC EMP03;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

INSERT INTO EMP03
VALUES(7499, 'ALLEN', 'SALESMAN', 10);

INSERT INTO EMP03
VALUES(7499, 'SCOTT', 'MANAGER', 20);

INSERT INTO EMP03
VALUES(NULL, 'SCOTT', 'MANAGER', 20);

SELECT * FROM EMP03;

INSERT INTO EMP03
VALUES(NULL, 'JOHNS', 'ANALYST', 30);


--CONSTRAINT NAME 지정 방법
DROP TABLE EMP04;

CREATE TABLE EMP04 (
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE,
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2)
);

INSERT INTO EMP04
VALUES(7499, 'ALLEN', 'SALESMAN', 10);

INSERT INTO EMP04
VALUES(7499, 'SCOTT', 'MANAGER', 20);

INSERT INTO EMP04
VALUES(7455, NULL, 'MANAGER', 20);

SELECT * FROM EMP04;

--PRIMARY KEY
DROP TABLE EMP05;

CREATE TABLE EMP05 (
    EMPNO NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2)
);

INSERT INTO EMP05
VALUES(7499, 'ALLEN', 'SALESMAN', 10);

INSERT INTO EMP05
VALUES(7499, 'SCOTT', 'MANAGER', 20);

INSERT INTO EMP05
VALUES(NULL, 'SCOTT', 'MANAGER', 20);

SELECT * FROM EMP05;


--FOREIGN KEY
SELECT * FROM DEPT;
SELECT * FROM EMP;

INSERT INTO EMP(EMPNO, ENAME, DEPTNO)
VALUES(8000, 'TEST', 50);

DROP TABLE EMP06;

CREATE TABLE EMP06(
    EMPNO NUMBER(4) CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP06_ENAME_NN NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(2) CONSTRAINT EMP06_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);

SELECT * FROM EMP06;

INSERT INTO EMP06
VALUES(7499, 'ALLEN', 'SALESMAN', 10);

INSERT INTO EMP06
VALUES(7566, 'SCOTT', 'MANAGER', 50);

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP06';


--CHECK
DROP TABLE EMP07;

CREATE TABLE EMP07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    SAL NUMBER(7, 2) CONSTRAINT EMP07_SAL_CK CHECK(SAL BETWEEN 500 AND 5000),
    GENDER VARCHAR2(1) CONSTRAINT EMP07_GENDER_CK CHECK(GENDER IN('M', 'F'))
);

INSERT INTO EMP07
VALUES(7499, 'ALLEN', 3000, 'M');

SELECT * FROM EMP07;

INSERT INTO EMP07
VALUES(7699, 'MARY', 6000, 'F');

INSERT INTO EMP07
VALUES(7699, 'MARY', 4500, 'F');

INSERT INTO EMP07
VALUES(7899, 'QUEEN', 3300, 'Q');

INSERT INTO EMP07
VALUES(7899, 'QUEEN', 3300, 'q');

INSERT INTO EMP07
VALUES(7899, 'QUEEN', 3300, 'F');


--DEFAULT
DROP TABLE DEPT01;

CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) DEFAULT 'SEOUL'
);

INSERT INTO DEPT01 (DEPTNO, DNAME)
VALUES(10, 'ACCOUNTING');

SELECT * FROM DEPT01;

--테이블 레벨 형식으로 CONSTRAINT 조건 지정하기
DROP TABLE EMP02;

CREATE TABLE EMP02(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    DEPTNO NUMBER(4),
    --TABEL LABEL CONSTRAINT 지정
    PRIMARY KEY(EMPNO),
    UNIQUE(JOB),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
);

DESC EMP02;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP02';

DROP TABLE EMP03;

CREATE TABLE EMP03(
    EMPNO NUMBER(4) CONSTRAINT EMP03_ENAME_NN NOT NULL,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    DEPTNO NUMBER(4),
    --TABLE LAVEL CONSTRAINT 지정
    CONSTRAINT EMP03_EMPNO_PK PRIMARY KEY(EMPNO),
    CONSTRAINT EMP03_JOB_UK UNIQUE(JOB),
    CONSTRAINT EMP03_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
);

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP03';


--복합키를 기본키로 지정(테이블레벨 제약조건 사용)
DROP TABLE MEMBER01;

CREATE TABLE MEMBER01 (
    NAME VARCHAR2(10),
    HPHONE VARCHAR2(16),
    ADDRESS VARCHAR2(30),
    --복합키를 TABLE LEVEL로 CONSTRAINT 지정
    CONSTRAINT MEMBER01_COMBO_PK PRIMARY KEY(NAME, HPHONE)
);

DESC MEMBER01;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MEMBER01';

SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='MEMBER01';

--TABLE 생성 후 CONSTRAINT 추가하기
DROP TABLE EMP01;

CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    DEPTNO NUMBER(4)
--  CONSTRAINT EMP01_EMPNO_PK PRIMARY KEY(EMPNO)  
--  CONSTRAINT EMP01_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
);

SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME='EMP01';

--TABLE LEVEL에서 CONSTRAINT 추가
ALTER TABLE EMP01
ADD CONSTRAINT EMP01_EMPNO_PK PRIMARY KEY(EMPNO);

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP01';

--TABLE LEVEL에서 CONSTRAINT 추가
ALTER TABLE EMP01
ADD CONSTRAINT EMP01_DEPTNO_FK
FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO);

--COLUMN LEVEL에서 CONSTRAINT 추가
ALTER TABLE EMP01
MODIFY ENAME CONSTRAINT EMP01_ENAME_NN NOT NULL;

--TABLE에 설정된 CONSTRAINT 제거
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP05';

SELECT * FROM EMP05;

--PRIMARY KEY CONSTARINT 삭제
ALTER TABLE EMP05
DROP CONSTRAINT EMP05_EMPNO_PK;

INSERT INTO EMP05
VALUES(7499, 'MARY', 'ANALYST', 20);

ALTER TABLE EMP05
DROP CONSTRAINT EMP05_ENAME_NN;

INSERT INTO EMP05
VALUES(7566, NULL, 'CLERK', 30);

















