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

 -- 문제
 
DELETE FROM member WHERE id = "asd";
CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    name VARCHAR(20)
);
SELECT * FROM member;

SELECT name FROM member WHERE id = "asd" AND password = "asd"; 
