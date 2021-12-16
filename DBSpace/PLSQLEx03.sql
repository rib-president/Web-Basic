SET SERVEROUTPUT ON
DECLARE
    VEMPNO NUMBER(4);
    VENAME VARCHAR2(20);
    VDEPTNO EMP.DEPTNO%TYPE;
    VDNAME VARCHAR2(20) := NULL;
BEGIN
    SELECT EMPNO, ENAME, DEPTNO INTO VEMPNO, VENAME, VDEPTNO
        FROM EMP
        WHERE EMPNO = 7788;
    IF (VDEPTNO = 10) THEN
        VDNAME := 'ACCOUNTING';
    END IF;
    IF (VDEPTNO = 20) THEN
        VDNAME := 'RESEARCH';
    END IF;
    IF (VDEPTNO = 30) THEN
        VDNAME := 'SALES';
    END IF;
    IF (VDEPTNO = 40) THEN
        VDNAME := 'OPERATIONS';
    END IF;
    DBMS_OUTPUT.PUT_LINE('사번    이름   부서명');
    DBMS_OUTPUT.PUT_LINE(VEMPNO || '   ' || VENAME || '   ' || VDNAME);   
END;
/