USE scott;

SELECT * FROM member;
SELECT * FROM product;
-- SELECT * FROM memberproduct;
-- SELECT * FROM member_product;
SELECT * FROM order_data;


SELECT * FROM dept;
SELECT * FROM emp;
DESC dept;
DESC emp;

INSERT INTO `DEPT` (`DEPTNO`, `DNAME`, `LOC`) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');