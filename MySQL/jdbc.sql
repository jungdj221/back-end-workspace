CREATE TABLE person(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(30)
);

SELECT * FROM person;


INSERT INTO person VALUES(999, "테스트", "서울");

DELETE FROM person WHERE id BETWEEN 111 AND 333;

UPDATE person SET id = 111 AND adress = "제주도" WHERE id = 999;

SELECT * FROM person;
-- -------------------------------------------------------------------------------
 -- 문제
 
 SELECT * FROM member;
 
DELETE FROM member WHERE id = "wds";
DELETE FROM member WHERE id LIKE "user%";

CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    name VARCHAR(20)
);
SELECT name FROM member WHERE id = "asd" AND password = "asd"; 

-- ------------------------------------------------------------------
-- 2024- 02-05 transcation
 SELECT * FROM member;
 CREATE TABLE bank(
	name VARCHAR(20),
    bankname VARCHAR(20),
    balance INT
 );
 INSERT INTO bank VALUES("정대윤", "국민은행", 1000000);
 INSERT INTO bank VALUES("신대규", "신한은행", 0);
 
 SELECT * FROM bank;
 
 UPDATE bank SET balance = 500000 WHERE name = "정대윤";
 UPDATE bank SET balance = 500000 WHERE name = "신대규";
 
 
 
 
 
 