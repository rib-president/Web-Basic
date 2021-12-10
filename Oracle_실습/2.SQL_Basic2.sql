SELECT * FROM emp;

SELECT empno, ename, sal FROM emp;

SELECT empno, ename, sal
FROM emp
WHERE sal > 3000;

SELECT empno, ename, sal
FROM emp
WHERE sal <= 3000;

SELECT empno, ename, sal
FROM emp
WHERE sal <> 3000;

--급여가 1500 이하인 사원의 사원번호, 사원 이름, 급여를 출력하는 SQL문을 작성해 보시오.
SELECT empno, ename, sal
FROM emp
WHERE sal <= 1500;


SELECT  empno, ename, sal
FROM emp
WHERE ename = 'FORD';

SELECT empno, ename, sal
FROM emp
WHERE ename = 'SCOTT';

SELECT *
FROM emp
WHERE hiredate <= '1982/01/01';

SELECT *
FROM emp
WHERE hiredate <= '82/01/01';

SELECT *
FROM emp
WHERE hiredate <= '82-01-01';

SELECT *
FROM emp
WHERE hiredate <= '82+01+01';

SELECT *
FROM emp
WHERE hiredate BETWEEN '1982-01-01' AND '1982-12-31';

SELECT *
FROM emp
WHERE deptno=10 AND job='MANAGER';

SELECT *
FROM emp
WHERE deptno=10 OR job='MANAGER';

SELECT *
FROM emp
WHERE NOT deptno=10;


SELECT *
FROM emp
WHERE sal >= 2000 AND sal <= 3000;

SELECT *
FROM emp
WHERE comm IN (300, 500, 1400);

SELECT *
FROM emp
WHERE comm = 300 OR comm = 500 OR comm = 1400;

SELECT *
FROM emp
WHERE sal BETWEEN 2000 AND 3000;

--급여가 2000미만이거나 3000초과인 사원 조회
SELECT *
FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000;

--1981년도에 입사한 사원
SELECT *
FROM emp
WHERE hiredate BETWEEN '1981/01/01' AND '1981/12/31';

--사원번호가 7521이거나 7654이거나 7844인 사원을 IN 이용해 검색
SELECT empno, sal
FROM emp
WHERE empno IN (7521, 7654, 7844);

SELECT empno, sal
FROM emp
WHERE empno NOT IN (7521, 7654, 7844);

SELECT *
FROM emp
WHERE ename LIKE 'F%';

SELECT *
FROM emp
WHERE ename LIKE 'J%';

SELECT *
FROM emp
WHERE ename LIKE '%A%';

SELECT *
FROM emp
WHERE ename LIKE '%N';

SELECT *
FROM emp
WHERE ename LIKE '__A%';

SELECT *
FROM emp
WHERE ename NOT LIKE '%A%';

--comm이 null인 데이터 검색
SELECT *
FROM emp
WHERE comm IS NULL;

SELECT *
FROM emp
WHERE comm IS NOT NULL;

SELECT *
FROM emp
WHERE mgr IS NULL;


SELECT *
FROM emp
ORDER BY comm;

SELECT *
FROM emp
ORDER BY comm DESC;

SELECT empno, ename, job, hiredate
FROM emp
ORDER BY hiredate DESC;

SELECT *
FROM emp
ORDER BY sal DESC, ename;


-- SQL 주요함수

DESC dual;

SELECT 30*50 FROM dual;

SELECT systimestamp FROM dual;

SELECT -10, ABS(-10) FROM dual;

SELECT 34.5678, FLOOR(34.5678) FROM dual;

SELECT 34.5678, CEIL(34.5678) FROM dual;

SELECT 34.5678, ROUND(34.5678, 2) FROM dual;

SELECT 34.5678, ROUND(34.5678, -1) FROM dual;

SELECT TRUNC(34.5678, 2), TRUNC(34.5678, -1), TRUNC(34.5678) FROM dual;

SELECT MOD(27, 2), MOD(27, 5), MOD(27, 7) FROM dual;

--사번이 홀수인 사람들을 검색해 보십시오.
SELECT *
FROM emp
WHERE MOD(empno, 2) = 1;

SELECT *
FROM emp
WHERE MOD(empno, 2) = 0;

--문자처리함수
SELECT 'Welcome to Oracle', UPPER('Welcome to Oracle') FROM dual;

SELECT * FROM emp WHERE LOWER(ename) = 'miller';

SELECT LENGTH('Oracle'), LENGTH('오라클') from dual;

SELECT LENGTHB('Oracle'), LENGTHB('오라클') from dual;

SELECT SUBSTR('Welcome to Oracle', 4, 3) from dual;
SELECT SUBSTR('Welcome to Oracle', -4, 3) from dual;

--9월 입사자
SELECT *
FROM emp
WHERE SUBSTR(hiredate, 4, 2) = '09';

--81년도 입사자
SELECT *
FROM emp
WHERE SUBSTR(hiredate, 1, 2) = '81';

--INSTR
SELECT INSTR('WELCOME TO ORACLE', 'O') FROM dual;
SELECT INSTR('WELCOME TO ORACLE', 'O', 6, 2) FROM dual;

--이름의 뒤에서 세 번째 자리가 T
SELECT *
FROM emp
WHERE ename LIKE '%T__';

--이름의 세 번째 자리가 R
SELECT *
FROM emp
WHERE ename LIKE '__R%';

SELECT *
FROM emp
WHERE INSTR(ename, 'R') = 3;

--특정기호를 채우는 LPAD/RPAD
SELECT LPAD('Oracle', 3, '#') FROM dual;
SELECT RPAD('Oracle', 20, '#') FROM dual;

--TRIM
SELECT LTRIM('  Oracle  ') FROM dual;
SELECT RTRIM('  Oracle  ') FROM dual;
SELECT TRIM('  Oracle  ') FROM dual;

--날짜함수
SELECT SYSDATE FROM dual;

SELECT sysdate-1 어제, sysdate 오늘, sysdate+1 내일 FROM dual;

--사원들의 근무일수
SELECT ROUND(SYSDATE - hiredate, 2) 근무일수
FROM emp;

SELECT hiredate, ROUND(hiredate, 'MONTH') FROM emp;

SELECT hiredate, TRUNC(hiredate, 'MONTH') FROM emp;

SELECT ename, SYSDATE, hiredate, MONTHS_BETWEEN(SYSDATE, hiredate) FROM emp;

SELECT SYSDATE, NEXT_DAY(SYSDATE, '수요일') FROM dual;

SELECT hiredate, LAST_DAY(hiredate) FROM emp;

--형변환 함수
--TO_CHAR
SELECT hiredate, TO_CHAR(hiredate, 'YYYY/MM/DD DAY') FROM emp;

SELECT hiredate, TO_CHAR(hiredate, 'YY/MM/DD DY') FROM emp;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD, HH24 : MI : SS') FROM dual;

SELECT TO_CHAR(1239999) FROM dual;

SELECT ename, sal, TO_CHAR(sal, 'L999,999') FROM emp;

SELECT ename, sal, TO_CHAR(sal, 'L999,999'), TO_CHAR(sal, 'L000,000') FROM emp;

--TO_DATE
SELECT ename, hiredate
FROM emp
WHERE hiredate = TO_DATE(19810220, 'YYYYMMDD');

SELECT ename, hiredate
FROM emp
WHERE hiredate = TO_DATE('1981-02-20', 'YYYY-MM-DD');

--TO_NUMBER
SELECT TO_NUMBER('20,000', '99,999') - TO_NUMBER('10,000', '99,999') FROM dual;

--NVL
SELECT ename, sal, comm, sal*12+NVL(comm, 0) 연봉 FROM emp;

--decode(swtich case)
SELECT deptno, DECODE(deptno, 10, 'ACCOUNTING',
		20, 'RESEARCH',
		30, 'SALES',
		40, 'OPERATIONS')
	AS DNAME
FROM emp;



SELECT SUM(sal) FROM emp;

SELECT SUM(comm) FROM emp;

SELECT TRUNC(AVG(sal),2) FROM emp;

SELECT MAX(sal), MIN(sal) FROM emp;

SELECT COUNT(*), COUNT(comm) FROM emp;

SELECT COUNT(job), COUNT(DISTINCT job) FROM emp;

--가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일
SELECT MAX(hiredate) 최근입사일자, MIN(hiredate) 최초입사일자 FROM emp;

--group by
SELECT deptno
FROM emp
GROUP BY deptno;

SELECT deptno, TRUNC(AVG(sal), 2), MAX(sal), MIN(sal), COUNT(*) 사원수
FROM emp
GROUP BY deptno;

SELECT deptno, TRUNC(AVG(sal), 2)
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2900;

--join
SELECT ename, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

SELECT ename, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno AND ename = 'SCOTT';

SELECT ename, dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE ename = 'SCOTT';

SELECT E.ename, D.dname, E.deptno, D.deptno
FROM emp E, dept D
WHERE E.deptno = D.deptno
AND E.ename = 'SCOTT';

--뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오.
SELECT e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.loc = 'NEW YORK';

--ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오.
SELECT e.ename, e.hiredate
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.dname = 'ACCOUNTING';

--직급이 MANAGER인 사원의 이름과 부서명을 출력하시오.
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.job = 'MANAGER';

SELECT * FROM salgrade;

SELECT *
FROM emp, salgrade;

--NON-EQUI JOIN
SELECT ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal;

SELECT ename, dname, grade
FROM emp, dept, salgrade
WHERE emp.deptno = dept.deptno AND sal BETWEEN losal AND hisal;

--Self Join
SELECT e.ename || '의 매니저는 ' || m.ename || '입니다.'
FROM emp e, emp m
WHERE e.mgr = m.empno;

--매니저가 KING인 사원들의 이름과 직급을 출력하시오.
SELECT e.ename, e.job
FROM emp e, emp m
WHERE e.mgr = m.empno AND m.ename = 'KING';

SELECT *
FROM emp e, emp m;

--SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하시오.
SELECT m.ename
FROM emp e, emp m
WHERE e.deptno = m.deptno AND e.ename = 'SCOTT' AND m.ename != 'SCOTT'; 

--LEFT OUTER JOIN
SELECT e.ename || '의 매니저는 ' || m.ename || '입니다.'
FROM emp e, emp m
WHERE e.mgr = m.empno(+);

SELECT e.ename || '의 매니저는 ' || m.ename || '입니다.'
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;


--ANSI JOIN 예제
--1.CROSS JOIN(Cartisian Product)
SELECT *
FROM emp CROSS JOIN dept;

--2.INNER JOIN
SELECT ename, dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno; 

SELECT ename, dname
FROM emp INNER JOIN dept
USING(deptno);

SELECT ename, dname
FROM emp INNER JOIN dept
USING(deptno)
WHERE ename = 'SCOTT';

--3.Natural Join
SELECT *
FROM emp NATURAL JOIN dept;

