--부속질의

--박지성에 대한 group by를 적용한 효과
SELECT SUM(salesprice)
FROM orders
WHERE custid = (
    SELECT custid
    FROM customer
    WHERE name = '박지성'
);

SELECT * FROM orders;

--1)SELECT에서 사용하는 부속질의(SCALAR 부속질의)
SELECT custid, SUM(salesprice)
FROM orders od
GROUP BY custid;

SELECT custid, (SELECT name
                FROM customer cs
                WHERE cs.custid=od.custid),
    SUM(salesprice)
FROM orders od
GROUP BY custid;

--2)INLINE VIEW(FROM에서 부속질의를 사용하여 TABLE처럼 보이기 때문에 INLINE VIEW라고 함)
SELECT cs.name, SUM(od.salesprice) "total"
FROM (SELECT custid, name
    FROM customer
    WHERE custid <= 2) cs,
    orders od
WHERE cs.custid = od.custid
GROUP BY cs.name;

--3)중첩질의(WHERE조건문에서 부속질의 사용)
SELECT orderid, custid, salesprice
FROM orders od
WHERE salesprice > (SELECT AVG(salesprice)
                    FROM orders so
                    WHERE od.custid = so.custid);
                    
SELECT SUM(salesprice) "total"
FROM orders od
WHERE custid IN (SELECT custid
                FROM customer
                WHERE address LIKE '%대한민국%');


--ALL : 모든
SELECT orderid, salesprice
FROM orders
WHERE salesprice > ALL(SELECT salesprice
                        FROM orders
                        WHERE custid='3');

SELECT orderid, salesprice
FROM orders
WHERE salesprice > (SELECT MAX(salesprice)
                        FROM orders
                        WHERE custid='3');

--SOME(ANY) : 하나라도
SELECT orderid, salesprice
FROM orders
WHERE salesprice > ANY (SELECT salesprice
                        FROM orders
                        WHERE custid='3');

SELECT orderid, salesprice
FROM orders
WHERE salesprice > (SELECT MIN(salesprice)
                        FROM orders
                        WHERE custid='3');

--EXISTS, NOT EXISTS
SELECT SUM(salesprice) "total"
FROM orders od
WHERE EXISTS (SELECT *
            FROM customer cs
            WHERE address LIKE '%대한민국%' AND cs.custid=od.custid);
            
SELECT SUM(salesprice) "total"
FROM orders od
WHERE NOT EXISTS (SELECT *
            FROM customer cs
            WHERE address LIKE '%대한민국%' AND cs.custid=od.custid);


--ROWNUM
SELECT ROWNUM, custid, name, phone
FROM customer;

SELECT ROWNUM, book.* from book;

SELECT ROWNUM "순번", custid, name, phone
FROM customer
WHERE ROWNUM <= 2;

--book table에서 price가 가장 작은 2개의 책을 선택
--1)order by 적용하여 오름차순으로 sorting -> price가 가장 작은 2개 책을 선택 불가
SELECT ROWNUM, book.*
FROM book
ORDER BY price;

--2)price로 order by 된 뷰를 가져와 rownum이 2보다 작은 튜플 조회
SELECT ROWNUM, b.*
FROM (SELECT * FROM book ORDER BY price) b
WHERE ROWNUM <= 2;

--책 값이 가장 비싼 3개의 행을 선택
SELECT ROWNUM, b.*
FROM (SELECT * FROM book ORDER BY price DESC) b
WHERE ROWNUM <= 3;











