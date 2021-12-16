--table space 생성
CREATE TABLESPACE md_tbs
DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\md_tbs_data01.dbf'
SIZE 10M;

CREATE TABLESPACE md_test
DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\md_test_data01.dbf'
SIZE 10M;

--table space 삭제
DROP TABLESPACE md_test
INCLUDING CONTENTS AND DATAFILES;

--USER 생성
CREATE USER mdguest
IDENTIFIED BY mdguest;

CREATE USER mdguest2
IDENTIFIED BY mdguest2
DEFAULT TABLESPACE md_tbs;

GRANT CONNECT, RESOURCE TO mdguest;
GRANT CONNECT, RESOURCE TO mdguest2;

--conn madang
--madang 소유의 테이블에 대한 권한 부여
GRANT SELECT ON BOOK TO mdguest;
GRANT SELECT, UPDATE ON customer TO mdguest WITH GRANT OPTION;
GRANT SELECT ON orders TO PUBLIC;


--conn mdguest
SELECT * FROM madang.book;

SELECT * FROM madang.customer;

SELECT * FROM madang.orders;

GRANT SELECT ON madang.book TO mdguest2;

GRANT SELECT ON madang.customer TO mdguest2;


--conn mdguest2

SELECT * FROM madang.customer;

SELECT * FROM madang.orders;


--conn madang
--REVOKE
REVOKE SELECT ON book FROM mdguest;
REVOKE SELECT ON customer FROM mdguest;

--conn mdguest
SELECT * FROM madang.book;
SELECT * FROM madang.customer;


--conn sys 또는 system
--ROLE 생성
CREATE ROLE programmer;

--ROLE에 권한부여
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO programmer;

--사용자에게 ROLE 부여
GRANT programmer TO mdguest;
GRANT SELECT, INSERT ON mdguest2.NEWTABLE TO programmer;

--conn mdguest2
CREATE TABLE NEWTABLE (
    myname VARCHAR2(40),
    myphone VARCHAR2(20)
);

--conn mdguest
CREATE TABLE mdguest.NEWTABLE (
    myname VARCHAR2(40),
    myphone VARCHAR2(20)
);

INSERT INTO mdguest2.NEWTABLE
VALUES ('홍길동', '000-000-0100');

SELECT * FROM mdguest2.NEWTABLE;

COMMIT;

--conn mdguest2
SELECT * FROM NEWTABLE;

--ROLE 삭제
DROP ROLE programmer;












