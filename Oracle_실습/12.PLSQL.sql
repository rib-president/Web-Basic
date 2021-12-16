--PL/SQL : SQL에 절차적 프로그래밍 언어(통상 C)를 가미

--Oracle PL/SQL로 짠 프로그램 결과 값을 console에 출력하라는 설정
SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO, PLSQL');
END;
/

--변수 선언하고 사용하기
DECLARE
    VEMPNO NUMBER(4);
    VENAME VARCHAR2(10);
BEGIN
    VEMPNO := 7788;
    VENAME := 'SCOTT';
    DBMS_OUTPUT.PUT_LINE('사번    /   이름');
    DBMS_OUTPUT.PUT_LINE('------------------');
    DBMS_OUTPUT.PUT_LINE(VEMPNO || ' / ' || VENAME);
END;
/


--SELECT문을 사용하여 EMP 테이블 내 사번과 이름 검색하기
DECLARE
    VEMPNO EMP.EMPNO%TYPE;  --VEMPNO의 타입을 EMP.EMPNO의 타입(NUMBER(4))으로 선언
    VENAME EMP.ENAME%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('사번    /   이름');
    DBMS_OUTPUT.PUT_LINE('------------------');
    SELECT EMPNO, ENAME INTO VEMPNO, VENAME
        FROM EMP
        WHERE ENAME = 'SCOTT';
    DBMS_OUTPUT.PUT_LINE(VEMPNO || ' / ' || VENAME);
END;
/














