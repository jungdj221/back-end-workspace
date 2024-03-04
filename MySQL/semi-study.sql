DROP TABLE member;
CREATE TABLE member(
	member_id VARCHAR(20) PRIMARY kEY,
    member_pwd VARCHAR(20),
    member_name VARCHAR(20)
);



CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(100),
    name VARCHAR(20),
    auth VARCHAR(20) DEFAULT 'ROLE_MEMBER',
    enabled int DEFAULT 1
);
SELECT * FROM member;
UPDATE member SET auth='ROLE_ADMIN' WHERE id='user02';
UPDATE member SET enabled=0 WHERE id='test_dana';

-- -------------------------------------------------------------

SELECT * FROM sample;
CREATE TABLE sample(
	sample_code INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(200), -- 명칭
    addr VARCHAR(200), -- 주소
    outline TEXT, -- 개요
    use_hour TEXT, -- 이용 시간
    start_date DATE, -- 시작 날짜
    end_date DATE, -- 마감 날짜
    detail TEXT -- 상세정보
);



-- ----------sakila

SELECT * FROM sakila.film_text
LIMIT 0, 10;

-- 첫 페이지 일 때(page=1) :  LIMIT 0, 10
-- 두 번째 페이지(page=2) : LIMIT 10, 10
-- 세 번째 페이지(page=3) : LIMIT 20, 10


-- ---------------- kh 이미지 업로드
CREATE TABLE board(
	no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    content VARCHAR(500),
    date DATE DEFAULT (current_date),
    url VARCHAR(200)
);
SELECt * FROM board;