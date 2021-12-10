-- 1) Customer table의 모든 행 정보 가져오기
select * from customer;
-- 2) Customer table에서 name이 김연아인 row(행)을 가져오기(selection)
select * from customer where name='김연아';
-- 3) Customer table에서 name이 김연아인 row(행)에서 phone 정보만 가져오기
select phone from customer where name='김연아';

select bookname, price from book;

select price, bookname from book;

select bookid, bookname, publisher, price from book;

select * from book;

select publisher from book;

select distinct publisher from book;

select * from book where price<20000;

select * from book where price between 10000 and 20000;

select *
from book
where price >= 10000 and price <= 20000;

select * from book where publisher in ('굿스포츠', '대한미디어');

SELECT *
FROM book
WHERE publisher = '굿스포츠' or publisher = '대한미디어';

SELECT *
FROM book
WHERE publisher NOT IN ('굿스포츠', '대한미디어');

SELECT *
FROM book
WHERE publisher != '굿스포츠' and publisher != '대한미디어';

SELECT bookname, publisher
FROM book
WHERE bookname LIKE '축구의 역사';

SELECT bookname, publisher
FROM book
WHERE bookname LIKE '%축구%';

SELECT bookname, publisher
FROM book
WHERE bookname LIKE '%야구%';

SELECT *
FROM book
WHERE bookname LIKE '_구%';

SELECT *
FROM book
WHERE bookname LIKE '__의%';

SELECT *
FROM book
WHERE bookname LIKE '%축구%' AND price>=20000;

SELECT *
FROM book
WHERE publisher='굿스포츠' OR publisher='대한미디어';

SELECT *
FROM book
ORDER BY bookname;

SELECT *
FROM book
ORDER BY price DESC;

SELECT * FROM book ORDER BY publisher;

SELECT *
FROM book
ORDER BY price, publisher;

SELECT *
FROM book
ORDER BY price DESC, publisher ASC;

select * from orders;

select sum(salesprice) from orders;

SELECT SUM(salesprice) AS 총매출 FROM orders;

SELECT COUNT(*) FROM orders;

SELECT COUNT(*) AS 도서수량, SUM(salesprice) AS 총액
FROM orders;

SELECT custid, COUNT(*) AS 도서수량, SUM(salesprice) AS 총액
FROM orders
GROUP BY custid;

SELECT custid, bookid, COUNT(*) AS 도서수량, SUM(salesprice) AS 총액
FROM orders
GROUP BY custid, bookid ORDER BY custid;

SELECT custid, COUNT(*) AS 도서수량
FROM orders
WHERE salesprice >= 8000
GROUP BY custid
HAVING COUNT(*) >= 2;

SELECT * FROM customer, orders;

SELECT *
FROM customer, orders
WHERE customer.custid = orders.custid;

SELECT *
FROM customer, orders
WHERE customer.custid = orders.custid
ORDER BY customer.custid;

SELECT name, salesprice
FROM customer, orders
WHERE customer.custid = orders.custid;

-- 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객별로 정렬하시오
SELECT name, SUM(salesprice)
FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY name
ORDER BY name;

SELECT customer.custid, customer.name, SUM(salesprice)
FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.custid, name
ORDER BY name;

SELECT *
FROM customer, orders, book;

--고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
SELECT name, bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid
AND orders.bookid = book.bookid;

--가격이 20,000원인 도서를 주문한 고객의 이름과 도서의 이름을 출력하시오.
SELECT name, bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid
AND orders.bookid = book.bookid
AND book.price = 20000;

--도서를 구매하지 않은 고객을 포함하여 고객의 이름과 고객이 주문한 도서의 판매가격을 구하시오.
--왼쪽 외부조인
SELECT customer.name, salesprice
FROM customer LEFT OUTER JOIN
    orders ON customer.custid = orders.custid;

SELECT customer.name, salesprice
FROM customer, orders
WHERE customer.custid = orders.custid(+);
--오른쪽 외부조인
SELECT customer.name, salesprice
FROM customer RIGHT OUTER JOIN
    orders ON customer.custid = orders.custid;
    
SELECT customer.name, salesprice
FROM customer, orders
WHERE customer.custid(+) = orders.custid;
--완전 외부조인
SELECT customer.name, salesprice
FROM customer FULL OUTER JOIN orders
ON customer.custid = orders.custid;

--부속질의(sub query)
SELECT bookname
FROM book
WHERE price = (
    SELECT MAX(price) FROM book
);

--도서를 구매한 적이 있는 고객의 이름을 검색하시오.
SELECT name
FROM customer
WHERE custid IN (
    SELECT custid FROM orders
);

SELECT DISTINCT name
FROM customer, orders
WHERE customer.custid = orders.custid;


--대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오.
SELECT name
FROM customer
WHERE custid IN (
    SELECT custid
    FROM orders
    WHERE bookid IN (
        SELECT bookid
        FROM book
        WHERE publisher = '대한미디어'
    )
);

SELECT name
FROM customer, orders, book
WHERE customer.custid = orders.custid
    AND orders.bookid = book.bookid
    AND publisher = '대한미디어';

--출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오.
SELECT b1.bookname
FROM book b1
WHERE b1.price > (
    SELECT AVG(b2.price)
    FROM book b2
    WHERE b2.publisher = b1.publisher
);


SELECT publisher, b1.bookname
FROM book b1
WHERE b1.price > (
    SELECT AVG(b2.price)
    FROM book b2
    WHERE b2.publisher = b1.publisher
);

SELECT publisher, AVG(price)
FROM book
GROUP BY publisher;

--도서를 주문하지 않은 고객의 이름을 보이시오.
SELECT name
FROM customer
MINUS
SELECT name
FROM customer
WHERE custid IN (
    SELECT custid
    FROM orders
);

--주문이 있는 고객의 이름과 주소를 보이시오.
SELECT name, address
FROM customer cs
WHERE EXISTS (SELECT *
    FROM orders od
    WHERE cs.custid = od.custid
);


SELECT name, address
FROM customer cs
WHERE NOT EXISTS (SELECT *
    FROM orders od
    WHERE cs.custid = od.custid
);