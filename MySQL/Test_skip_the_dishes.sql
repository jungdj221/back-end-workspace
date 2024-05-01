-- 음식배달 사이트
-- 1. 회원가입 : 일반 사용자 / 사업자
-- 배달 음식점 / 주문 음식 등록

-- 2. 사용자 
-- 로그인 없어도 조회는 가능, 주문 하려면 회원가입 해야함. 가입 후 로그인

-- 주문 가격의 2%씩 회원의 포인트로 적립 -- 포인트 컬럼

-- 3. 배달 음식 조회 - 카테고리 선택. SNS 주문으로 주문 정보가 사업자 사용자에게 전송 / 주문 한 사람은 문자 받음
-- 주문 완료도 사업자/ 사용자 둘다 SNS로 받음

-- 4. 사업자는 메뉴 등록, 수정, 삭제 가능!
drop table order_history;
drop table review_image;
drop table review;
drop table customer_order;
drop table menu_image;
drop table menu_register;
drop table business_register;
drop table food_category;
drop table user;

insert into user(user_id) values("비둘기");
-- 유저 정보 + 회원가입
CREATE TABLE user (
	user_id VARCHAR(20) PRIMARY KEY UNIQUE,
    user_password VARCHAR(20),
    user_name VARCHAR(20),
    user_address VARCHAR(100), -- 배달하려면 필요
    user_profile_url VARCHAR(300) DEFAULT ("default_URL"),
    user_phone_number VARCHAR(20), -- sns 문자
    user_register_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_app_point INT,
    user_role VARCHAR(20)
);

CREATE TABLE order_history(
	history_code INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20),
    order_code INT
);



-- 사업가 일때
CREATE TABLE business_register(
	registered_code INT AUTO_INCREMENT PRIMARY KEY,
    registered_license_url VARCHAR(300),
    registered_name VARCHAR(50),
    registered_address VARCHAR(100), -- 음식점 위치
	registered_category_code INT, -- 카테고리 코드 외래키
    business_user_id VARCHAR(20) -- 어떤 사업자가 올렸는지
);

-- 사업가 일때 - 메뉴 리스트
CREATE TABLE menu_register(
	menu_code INT AUTO_INCREMENT PRIMARY KEY,
    menu_registered_business_code INT, -- registed_code 외래키 어떤 음식점의 메뉴인지
    menu_category_code INT,
    menu_name VARCHAR(20),
    menu_name_desc TEXT,
    menu_price INT
);

CREATE TABLE menu_image(
	menu_image_code INT AUTO_INCREMENT PRIMARY KEY,
    menu_image_url VARCHAR(300),
    menu_code INT -- 어떤 메뉴에 대한 이미지 인지
);

-- 일반 유저일때
-- 일반유저 주문 리스트
CREATE TABLE customer_order(
	order_code INT AUTO_INCREMENT PRIMARY KEY,
    order_menu_code INT, -- 어떤거 시켰는지 여기에 음식점 정보도 조회 가능 외래키
    order_user_id VARCHAR(20), -- 누가 시켰는지 여기에 주소정보도 담겨있음 외래키
    order_complete_status CHAR(1) DEFAULT('N'),
    order_order_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE food_category(
	food_category_code INT PRIMARY KEY AUTO_INCREMENT,
    food_type VARCHAR(20)
);

CREATE TABLE review(
	revi_code INT AUTO_INCREMENT PRIMARY KEY,
    revi_user_id VARCHAR(20), -- 누가 썼는지
    revi_title VARCHAR(20),
    revi_decs TEXT
);

CREATE TABLE review_image(
	review_image_code INT AUTO_INCREMENT PRIMARY KEY,
    review_image_url VARCHAR(300),
    revi_code INT -- 어떤 메뉴에 대한 이미지 인지
);



alter table business_register add foreign key (business_user_id) references user(user_id);
alter table business_register add foreign key (registered_category_code) references food_category(food_category_code);
alter table menu_register add foreign key (menu_registered_business_code) references business_register(registered_code);
alter table menu_register add foreign key (menu_category_code) references food_category(food_category_code);
alter table customer_order add foreign key (order_menu_code) references menu_register(menu_code);
alter table customer_order add foreign key (order_user_id) references user(user_id);
alter table review add foreign key (revi_user_id) references user(user_id);
alter table review_image add foreign key (revi_code) references review(revi_code);
alter table menu_image add foreign key (menu_code) references menu_register(menu_code);
alter table order_history add foreign key (user_id) references user(user_id);
alter table order_history add foreign key (order_code) references customer_order(order_code);