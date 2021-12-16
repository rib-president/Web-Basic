--1.Stored Procedure (저장 프로시저, Java에서 return type void인 method)
DROP TABLE EMP01;

CREATE TABLE EMP01
AS
SELECT * FROM EMP;

SELECT * FROM EMP01;

--PROCEDURE를 데이터베이스에 저장하는 명령어(컴파일)
@C:\DevSpace\DBSpace\procedure01.sql;

EXECUTE DEL_ALL;

--저장 프로시저 조회하기
DESC USER_SOURCE;

SELECT NAME, TEXT FROM USER_SOURCE;

/*-------------------------------------------------------------------------*/

DROP TABLE EMP01;

CREATE TABLE EMP01
AS
SELECT * FROM EMP;

SELECT * FROM EMP01;

@C:\DevSpace\DBSpace\procedure02.sql;

EXECUTE DEL_ENAME('SMITH');

SELECT * FROM EMP01;

@C:\DevSpace\DBSpace\procedure03.sql;

--변수선언
VARIABLE VAR_ENAME VARCHAR2(15);
VARIABLE VAR_SAL NUMBER;
VARIABLE VAR_JOB VARCHAR2(9);

EXECUTE SEL_EMPNO(7788, :VAR_ENAME, :VAR_SAL, :VAR_JOB);

PRINT VAR_ENAME;
/*VAR_ENAME
--------------------------------------------------------------------------------
SCOTT*/
PRINT VAR_SAL;
/*   VAR_SAL
----------
      3000*/
PRINT VAR_JOB;
/*VAR_JOB
--------------------------------------------------------------------------------
ANALYST*/


--2.Function(Java에서 return값이 있는 method)
@C:\DevSpace\DBSpace\function01.sql;

VARIABLE VAR_RES NUMBER;

EXECUTE :VAR_RES := CAL_BONUS(7788);

PRINT VAR_RES;
/*   VAR_RES
----------
      6000*/
      
--SELECT문에서 선언된 함수 사용 가능
SELECT SAL, CAL_BONUS(7788)
FROM EMP
WHERE EMPNO=7788;

















