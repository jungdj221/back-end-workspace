-- DROP TABLE tb_publisher;
-- DROP TABLE tb_book;
-- DROP TABLE tb_member;
-- DROP TABLE tb_member;

DROP TABLE tb_rent;
DROP TABLE tb_member;
DROP TABLE tb_book;
DROP TABLE tb_publisher;

-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)

-- VARCHAR : 문자
-- 해설본
-- CREATE TABLE tb_publisher(
-- 	pub_no INT AUTO_INCREMENT PRIMARY KEY,
--     pub_name VARCHAR(20) NOT NULL,
--     phone VARCHAR(20),
-- ); 
-- INSERT INTO tb_publisher(pub_name, phone) VALUES('천그루숲', '010-8748-0784');
-- INSERT INTO tb_publisher(pub_name, phone) VALUES('골든레빗', '0505-398-0505');
-- INSERT INTO tb_publisher(pub_name, phone) VALUES('윌북', '031-955-3777');

-- CREATE TABLE tb_publisher(
-- 	pub_no INT PRIMARY KEY,
--     pub_name VARCHAR(20) NOT NULL,
--     phone VARCHAR(13)
-- );
-- INSERT INTO tb_publisher VALUES(1, '천그루숲', '010-8748-0784');
-- INSERT INTO tb_publisher VALUES(2, '골든레빗', '0505-398-0505');
-- INSERT INTO tb_publisher VALUES(3, '윌북', '031-955-3777');
-- SELECT * FROM tb_publisher;


-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정

-- 해설
-- CREATE TABLE tb_book(
-- 	bk_no INT AUTO_INCREMENT PRIMARY KEY,
--     bk_title VARCHAR(40) NOT NULL,
--     bk_author VARCHAR(10) NOT NULL,
--     bk_price INT,
--     pub_no INT, -- pub_no로 바꾸면 쉬워짐
--     FOREIGN KEY (bk_pub_no) 
-- );
-- INSERT INTO tb_book(bk_no, bk_title, bk_author, bk_price, bk_pub_no) VALUES ('오늘부터 개발자', '김병욱', 16800, 1);
-- INSERT INTO tb_book(bk_no, bk_title, bk_author, bk_price, bk_pub_no) VALUES ('요즘 우아한 개발', '우아한 형제들', 24000, 2);
-- INSERT INTO tb_book(bk_no, bk_title, bk_author, bk_price, bk_pub_no) VALUES ('코딩 좀 아는 사람', '제러미 키신', 17800, 3);
-- INSERT INTO tb_book(bk_no, bk_title, bk_author, bk_price, bk_pub_no) VALUES ('코딩 좀 아는 사람', '제러미 키신', 17800, 3);
-- INSERT INTO tb_book(bk_no, bk_title, bk_author, bk_price, bk_pub_no) VALUES ('그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);

DROP TABLE tb_book;
CREATE TABLE tb_book(
	bk_no INT PRIMARY KEY,
    bk_title VARCHAR(30) NOT NULL,
    bk_author VARCHAR(10) NOT NULL,
    bk_price INT,
    bk_pub_no INT,
    FOREIGN KEY (bk_pub_no) REFERENCES tb_publisher(pub_no) ON DELETE CASCADE
);

INSERT INTO tb_book VALUES(1, '오늘부터 개발자', '김병욱', 16800, 1);
INSERT INTO tb_book VALUES(2, '요즘 우아한 개발', '우아한 형제들', 24000, 2);
INSERT INTO tb_book VALUES(3, '프로덕트 매니저 원칙', '장홍석', 22000, 2);
INSERT INTO tb_book VALUES(4, '코딩 좀 아는 사람', '제러미 키신', 17800, 3);
INSERT INTO tb_book VALUES(5, '그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);
SELECT * FROM tb_book;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜

-- 해설
-- CREATE TABLE tb_member(
-- 	member_no INT AUTO_INCREMENT PRIMARY KEY,
--     member_id VARCHAR(30) UNIQUE NOT NULL,
--     member_pwd VARCHAR(30) NOT NULL,
--     member_name VARCHAR(15) NOT NULL,
--     gender VARCHAR(1) CHECK (gender IN('M','F')),
--     address VARCHAR(100),
--     phone VARCHAR(20),
--     status VARCHAR(1) DEFAULT 'N' CHECK (status IN ('Y','N')),
--     enroll_date DATE DEFAULT (current_date())
-- );
-- INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date) 
-- VALUES('user01','pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222');
-- INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date) 
-- VALUES('user02','pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444');
-- INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone, status, enroll_date) 
-- VALUES('user03','pass03', '강길순', 'F', '서울시 광주구', '010-4444-5555');

DROP TABLE tb_member;
CREATE TABLE tb_member(
	member_no INT PRIMARY KEY,
    member_id VARCHAR(15) UNIQUE,
    member_pwd VARCHAR(20) NOT NULL,
    member_name VARCHAR(10) NOT NULL,
    gender CHAR(3),
    address char(40),
    phone VARCHAR(13),
    status CHAR(3) DEFAULT 'N',
    enroll_date DATE DEFAULT (current_date()),
    CONSTRAINT gender CHECK (gender IN ('M','F')),
    CONSTRAINT status CHECK (status IN ('Y','N'))
);
INSERT INTO tb_member VALUES(1, 'user01','pass01', '홍길동', 'M', '서울시 강서구', '010-1111-2222', DEFAULT, DEFAULT);
INSERT INTO tb_member VALUES(2, 'user02','pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444', DEFAULT, DEFAULT);
INSERT INTO tb_member VALUES(3, 'user03','pass03', '강길순', 'F', '서울시 광주구', '010-4444-5555', DEFAULT, DEFAULT);
SELECT * FROM tb_member;

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

-- 해설
-- CREATE TABLE tb_rent(
-- 	rent_no INT AUTO_INCREMENT PRIMARY KEY,
--     member_no INT,
--     bk_no INT,
--     rent_date DATE DEFAULT (current_date()) ON DELETE SET NULL
-- );

CREATE TABLE tb_rent(
	rent_no INT AUTO_INCREMENT PRIMARY KEY,
    rent_mem_no INT,
    rent_book_no INT,
    rent_date DATE DEFAULT (current_date()),
	FOREIGN KEY (rent_mem_no) REFERENCES tb_member(member_no),
	FOREIGN KEY (rent_book_no) REFERENCES tb_book(bk_no) ON DELETE SET NULL

);
-- ALTER로 FOREIGN KEY만 관리
 ALTER TABLE tb_book ADD CONSTRAINT pub_no_fk
 	FOREIGN KEY (pub_no) REFERENCES tb_publisher(pub_no);
 ALTER TABLE tb_rent ADD CONSTRAINT member_no_fk 
 	FOREIGN kEY(member_no) REFERENCES tb_member(member_No);
 ALTER TABLE tb_rent ADD CONSTRAINT bk_no_fk
 	FOREIGN KEY(bk_no) REFERENCES tb_book(bk_no);
    
INSERT INTO tb_rent(member_no, bk_no) VALUES( 1, 2);
INSERT INTO tb_rent(member_no, bk_no) VALUES( 1, 3);
INSERT INTO tb_rent(member_no, bk_no) VALUES( 2, 1);
INSERT INTO tb_rent(member_no, bk_no) VALUES( 2, 2);
INSERT INTO tb_ren(member_no, bk_no) VALUES( 1, 5);
SELECT * FROM tb_rent;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.-- 
DROP TABLE tb_rent_check;
CREATE TABLE tb_rent_check 
AS SELECT distinct member_name, member_id, rent_date, adddate(rent_date, interval 7 day) 
FROM tb_rent, tb_member, tb_book
WHERE bk_no = 2;
SELECT * FROM tb_rent_check;

-- SELECT distinct member_name '회원이름', member_id '아아디', rent_date '대여일', adddate(rent_date, interval 7 day) '반납예정일'
-- FROM  tb_rent
-- JOIN tb_member ON (rent_mem_no = member_no)
-- JOIN tb_book ON (rent_book_no = bk_no)
-- WHERE rent_book_no =2 OR bk_no =2;


-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
DROP TABLE tb_rent_check2;
CREATE TABLE tb_rent_check2 
AS SELECT distinct bk_title, pub_name, rent_date, adddate(rent_date, interval 7 day), member_no 
FROM tb_rent, tb_member,tb_book, tb_publisher
WHERE member_no=1;
SELECT * FROM tb_rent_check2;

-- SELECT bk_title '도서명', pub_name '출판사명', rent_date '대여일', adddate(rent_date, interval 7 day) '반납예정일'
-- FROM tb_rent
--  JOIN tb_member ON (rent_mem_no = member_no)
-- JOIN tb_book ON (rent_book_no = bk_no)
-- JOIN tb_publisher ON(bk_pub_no=pub_no )
-- WHERE member_no=1;









-- jdbc를 위해 다시 드롭하고 재생성
-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

DROP TABLE tb_rent;
DROP TABLE tb_member;
DROP TABLE tb_book;
DROP TABLE tb_publisher;

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)
CREATE TABLE tb_publisher(
	pub_no INT AUTO_INCREMENT PRIMARY KEY,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(20)
);
INSERT INTO tb_publisher(pub_name, phone) VALUES('천그루숲', '010-8748-0784');
INSERT INTO tb_publisher(pub_name, phone) VALUES('골든래빗', '0505-398-0505');
INSERT INTO tb_publisher(pub_name, phone) VALUES('윌북', '031-955-3777');

SELECT * FROM tb_publisher;

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
CREATE TABLE tb_book(
	bk_no INT AUTO_INCREMENT PRIMARY KEY,
    bk_title VARCHAR(50) NOT NULL,
    bk_author VARCHAR(20) NOT NULL,
    bk_price INT,
    pub_no INT
);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no)
VALUES('오늘부터 개발자', '김병욱', 16800, 1);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no)
VALUES('요즘 우아한 개발', '우아한 형제들', 24000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no)
VALUES('프로덕트 매니저 원칙', '장홍석', 22000, 2);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no)
VALUES('코딩 좀 아는 사람', '제러미 키신', 17800, 3);
INSERT INTO tb_book(bk_title, bk_author, bk_price, pub_no)
VALUES('그렇게 쓰면 아무도 안 읽습니다', '전주경', 19800, 3);

SELECT * FROM tb_book;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜

CREATE TABLE tb_member(
	member_no INT AUTO_INCREMENT PRIMARY KEY,
    member_id VARCHAR(30) UNIQUE NOT NULL,
    member_pwd VARCHAR(30) NOT NULL,
    member_name VARCHAR(20) NOT NULL,
    gender VARCHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(100),
    phone VARCHAR(20),
    status VARCHAR(1) CHECK(status IN ('Y', 'N')) DEFAULT 'N',
    enroll_date DATE DEFAULT (current_date())
);
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
VALUES('user01', 'pass01', '홍길동', 'M', '서울시 강남구', '010-1111-2222');
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
VALUES('user02', 'pass02', '김말똥', 'M', '서울시 강남구', '010-3333-4444');
INSERT INTO tb_member(member_id, member_pwd, member_name, gender, address, phone)
VALUES('user03', 'pass03', '강길순', 'F', '경기도 광주시', '010-4444-5555');

SELECT * FROM tb_member;

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

CREATE TABLE tb_rent(
	rent_no INT AUTO_INCREMENT PRIMARY KEY,
    member_no INT,
    bk_no INT,
    rent_date DATE DEFAULT (current_date()) 
);

-- ALTER로 FOREIGN KEY만 관리
ALTER TABLE tb_book ADD CONSTRAINT pub_no_fk 
	FOREIGN KEY (pub_no) REFERENCES tb_publisher(pub_no) ON DELETE CASCADE;
ALTER TABLE tb_rent ADD CONSTRAINT member_no_fk 
	FOREIGN KEY(member_no) REFERENCES tb_member(member_no) ON DELETE CASCADE; 
ALTER TABLE tb_rent ADD CONSTRAINT bk_no_fk 
	FOREIGN KEY(bk_no) REFERENCES tb_book(bk_no) ON DELETE CASCADE; -- ON DELETE SET null=>없어지면 null로

INSERT INTO tb_rent(member_no, bk_no) VALUES(1, 2);
INSERT INTO tb_rent(member_no, bk_no) VALUES(1, 3);
INSERT INTO tb_rent(member_no, bk_no) VALUES(2, 1);
INSERT INTO tb_rent(member_no, bk_no) VALUES(2, 2);
INSERT INTO tb_rent(member_no, bk_no) VALUES(1, 5);

SELECT * FROM tb_rent;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
SELECT 
	member_name "회원 이름", 
    member_id "아이디", 
    rent_date "대여일", 
    adddate(rent_date, INTERVAL 7 DAY) "반납 예정일"
FROM tb_rent
	JOIN tb_member USING (member_no)
WHERE bk_no = 2;

-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
SELECT 
	bk_title "도서명",
    pub_name "출판사명",
    rent_date "대여일",
    adddate(rent_date, 7) "반납 예정일"
FROM tb_rent
	JOIN tb_book USING (bk_no)
    JOIN tb_publisher USING (pub_no)
WHERE member_no = 1;



