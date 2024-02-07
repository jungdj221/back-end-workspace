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
 
 -- ----------------------------------------------------
-- BOOK 문제
SELECT * FROM tb_book; 

INSERT INTO tb_book(bk_title, bk_author) VALUES("테스트", "테스트");
DELETE FROM tb_book WHERE bk_no = 9;

SELECT * FROM tb_member;
INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES("user1", "user11", "pigeon");
DELETE FROM tb_book WHERE bk_no=11;

SELECT * FROM tb_rent;
SELECT * FROM tb_rent WHERE member_no =2;
SELECT rent_no, bk_title, bk_author, rent_date, adddate(rent_date, interval 7 day)반납기한 FROM tb_rent JOIN tb_book USING(bk_no) WHERE member_no =1;
 DELETE FROM tb_rent WHERE rent_no =1;
 
UPDATE tb_member SET status='Y' WHERE member_no=4;