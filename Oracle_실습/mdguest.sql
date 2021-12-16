SELECT * FROM madang.book;

SELECT * FROM madang.customer;

SELECT * FROM madang.orders;

GRANT SELECT ON madang.book TO mdguest2;

GRANT SELECT ON madang.customer TO mdguest2;

SELECT * FROM madang.book;

CREATE TABLE mdguest2.NEWTABLE (
    myname VARCHAR2(40),
    myphone VARCHAR2(20)
);









