--conn madang
--1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(1) 도서번호가 1인 도서의 이름
SELECT bookname FROM book WHERE bookid = 1;

--(2) 가격이 20,000원 이상인 도서의 이름
SELECT bookname FROM book WHERE price >= 20000;

--(3) 박지성의 총 구매액
SELECT SUM(salesprice) "박지성 총 구매액"
FROM orders od INNER JOIN customer cs
ON od.custid = cs.custid
WHERE cs.name = '박지성';

--(4) 박지성이 구매한 도서의 수
SELECT COUNT(*) "박지성 구매 도서 수"
FROM orders od
WHERE od.custid = (SELECT cs.custid
                    FROM customer cs
                    WHERE cs.name = '박지성');
                    
--(5) 박지성이 구매한 도서의 출판사 수
SELECT COUNT(publisher) "박지성 구매 출판사 수"
FROM book, (SELECT bookid
            FROM orders od, customer cs
            WHERE od.custid = cs.custid AND cs.name = '박지성'
            ) oc
WHERE book.bookid = oc.bookid;

--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
SELECT bookname, price, (price - salesprice)
FROM orders od, customer cs, book
WHERE od.custid = cs.custid AND od.bookid = book.bookid
    AND cs.name = '박지성';

--(7) 박지성이 구매하지 않은 도서의 이름
SELECT bookname
FROM book, orders od
WHERE od.bookid = book.bookid
    AND od.custid IN (SELECT cs.custid
                    FROM customer cs
                    WHERE cs.name <> '박지성');
                    
/*==========================================================================*/
--2. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(1) 마당서점 도서의 총 개수
SELECT COUNT(*) "총 도서 수" FROM book;

--(2) 마당서점에 도서를 출고하는 출판사의 총 개수
SELECT COUNT(DISTINCT publisher) "총 출판사 수" FROM book;

--(3) 모든 고객의 이름, 주소
SELECT name, address FROM customer;

--(4) 2014년 7월 4일~7월 7일 사이에 주문받은 도서의 주문번호
SELECT orderid
FROM orders
WHERE orderdate BETWEEN '2014/07/04' AND '2014/07/07';

--(5) 2014년 7월 4일~7월 7일 사이에 주문받은 도서를 제외한 도서의 주문번호
SELECT orderid
FROM orders
WHERE orderdate NOT BETWEEN '2014/07/04' AND '2014/07/07';

--(6) 성이 ‘김’ 씨인 고객의 이름과 주소
SELECT name, address
FROM customer
WHERE name LIKE '김%';

--(7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
SELECT name, address
FROM customer
WHERE name LIKE '김%아';

--(8) 주문하지 않은 고객의 이름(부속질의 사용)
SELECT name
FROM customer
WHERE custid NOT IN (SELECT od.custid FROM orders od);

--(9) 주문 금액의 총액과 주문의 평균 금액
SELECT SUM(salesprice) 총액, AVG(salesprice) 평균금액
FROM orders;

--(10) 고객의 이름과 고객별 구매액
SELECT name, SUM(salesprice) 구매액
FROM customer cs, orders od
WHERE cs.custid = od.custid
GROUP BY name;

--(11) 고객의 이름과 고객이 구매한 도서 목록
SELECT name, bookname
FROM customer cs, book, orders od
WHERE cs.custid = od.custid AND od.bookid = book.bookid;

--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
SELECT *
FROM orders NATURAL JOIN book
WHERE (price - salesprice) = (SELECT MAX(price - salesprice)
                            FROM orders NATURAL JOIN book);

--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
SELECT name
FROM customer cs, orders od
WHERE cs.custid = od.custid
GROUP BY name
HAVING AVG(salesprice) > (SELECT AVG(salesprice) FROM orders);

/*==========================================================================*/
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
SELECT DISTINCT name
FROM customer NATURAL JOIN orders NATURAL JOIN book
WHERE publisher IN (SELECT publisher
                    FROM customer NATURAL JOIN orders NATURAL JOIN book
                    WHERE name = '박지성');

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름      
SELECT name
FROM orders od, book, customer cs
WHERE od.bookid = book.bookid AND cs.custid = od.custid
GROUP BY name
HAVING COUNT(DISTINCT publisher) >= 2;

--(3) 전체 고객의 30% 이상이 구매한 도서
SELECT bookname
FROM book, orders od
WHERE book.bookid = od.bookid
GROUP BY bookname
HAVING COUNT(*) > (SELECT COUNT(*) * 0.3 FROM customer);

/*==========================================================================*/
--conn Scott
/*4. [사원 데이터베이스] 다음은 scott 데이터베이스에 저장된 사원 데이터베이스다.
다음 질문에 대해 SQL 문을 작성하시오(부록 B의 scott 계정을 준비하였다면 예제 데이터베이스가 생성되어 있다).*/
/*Dept는 부서 테이블로 deptno(부서번호), dname(부서이름), loc(위치, location)으로 구성되어 있다.
Emp는 사원 테이블로 empno(사원번호), ename(사원이름), job(업무), MGR(팀장번호, manager),
hiredate(고용날짜), sal(급여, salary), comm(커미션금액, commission),deptno(부서번호)로 구성되어 있다.
밑줄 친 속성은 기본키이고 Emp의 deptno는 Dept의 deptno를 참조하는 외래키이다.*/
--(1) 사원의 이름과 직위를 출력하시오.
--단, 사원의 이름은 ‘사원이름’, 직위는 ‘사원직위’머리글이 나오도록 출력한다.
SELECT ename 사원이름, job 사원직위 FROM emp;

--(2) 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하시오.
SELECT ename, sal FROM emp WHERE deptno = 30;

--(3) 사원 번호와 이름, 현재 급여와 10% 인상된 급여(열 이름은 ‘인상된 급여’)를 출력하시오.
--단, 사원 번호순으로 출력한다. 증가된 급여분에 대한 열 이름은 ‘증가액’으로 한다.
SELECT empno, ename, sal, (sal * 1.1) "인상된 급여", (sal * 0.1) 증가액
FROM emp ORDER BY empno;

--(4) ‘S’로 시작하는 모든 사원과 부서번호를 출력하시오.
SELECT ename, deptno FROM emp WHERE UPPER(ename) LIKE 'S%';

--(5) 모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하시오.
--열 이름은 각각 MAX, MIN, SUM, AVG로 한다. 단, 소수점 이하는 반올림하여 정수로 출력한다.
SELECT MAX(sal) MAX, MIN(sal) MIN, SUM(sal) SUM, ROUND(AVG(sal)) AVG FROM emp;

--(6) 업무이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하시오.
--열 이름은 각각 ‘업무’와 ‘업무별 사원수’로 한다.
SELECT job 업무, COUNT(*) "업무별 사원수"
FROM emp
GROUP BY job;

--(7) 사원의 최대 급여와 최소 급여의 차액을 출력하시오.
SELECT MAX(sal) - MIN(sal) FROM emp;

--(8) 30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력하시오.
SELECT COUNT(*), SUM(sal), ROUND(AVG(sal), 2) FROM emp WHERE deptno = 30;

--(9) 평균급여가 가장 높은 부서의 번호를 출력하시오.
SELECT deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal) = (SELECT MAX(AVG(sal)) FROM emp GROUP BY deptno);

--(10) 세일즈맨을 제외하고, 각 업무별 사원들의 총 급여가 3000 이상인 각 업무에 대해서,
--업무명과 각 업무별 평균 급여를 출력하되, 평균급여의 내림차순으로 출력하시오.
SELECT job, ROUND(AVG(sal), 2) 평균급여
FROM emp
WHERE job <> 'SALESMAN'
GROUP BY job
HAVING SUM(sal) >= 3000
ORDER BY 평균급여 DESC;

--(11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하시오.
SELECT COUNT(mgr) FROM emp;

--(12) Emp 테이블에서 이름, 급여, 커미션 금액, 총액(sal + comm)을 구하여 총액이 많은 순서대로 출력하시오. 
--단, 커미션이 NULL인 사람은 제외한다.
SELECT ename, sal, comm, (sal + comm) 총액
FROM emp
WHERE comm IS NOT NULL
ORDER BY 총액 DESC;

--(13) 각 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하시오.
SELECT deptno, job, COUNT(*)
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

--(14) 사원이 한 명도 없는 부서의 이름을 출력하시오.
SELECT dname
FROM dept
WHERE deptno NOT IN (SELECT deptno FROM emp);

--(15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오.
SELECT job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 4;

--(16) 사원번호가 7400 이상 7600 이하인 사원의 이름을 출력하시오.
SELECT ename FROM emp WHERE empno BETWEEN 7400 AND 7600;

--(17) 사원의 이름과 사원의 부서를 출력하시오.
SELECT ename, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

--(18) 사원의 이름과 팀장의 이름을 출력하시오.
SELECT e.ename, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno;

--(19) 사원 SCOTT보다 급여를 많이 받는 사람의 이름을 출력하시오.
SELECT ename
FROM emp
WHERE sal > (SELECT sal
            FROM emp
            WHERE ename = 'SCOTT');
            
--(20) 사원 SCOTT가 일하는 부서번호 혹은 DALLAS에 있는 부서번호를 출력하시오.
SELECT DISTINCT deptno
FROM emp NATURAL JOIN dept
WHERE ename = 'SCOTT' OR loc = 'DALLAS';


                    