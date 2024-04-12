DROP TABLE recommand_logic;
DROP TABLE animal_board_image;
DROP TABLE animal_board_video;
DROP TABLE ad;
DROP TABLE animal_board_comment;
DROP TABLE animal_board_favorite;
DROP TABLE animal_board;
DROP TABLE animal_category;
DROP TABLE user;  -- user는 가장 마지막


select * from animal_board; 
select * from animal_board_image;
select * from user;
select * from animal_category;
-- 임시로 쓸 유저
CREATE TABLE user (  -- 이거는 상현님 테이블에서 빌려왔어요.
	user_id VARCHAR(20) PRIMARY KEY,
    user_name VARCHAR(20),
    user_phone VARCHAR(20),
    user_pwd VARCHAR(500),
    user_nickname VARCHAR(20),
    user_email  VARCHAR(50),
    user_status char(1) DEFAULT 'n',
    user_enroll_date TIMESTAMP DEFAULT current_timestamp,
    user_quit_date TIMESTAMP,
    user_role VARCHAR(20) DEFAULT 'ROLE_USER',
    user_img VARCHAR(500),
    user_point INT DEFAULT 0
    );
    
   
    
    INSERT INTO user(user_id, user_name, user_nickname, user_img) VALUES('pigeon221','정둘기','처음둥지지어본비둘기','비둘기사진1');
    INSERT INTO user(user_id, user_name, user_nickname, user_img) VALUES('pigeon331','김둘기','둥지지어본비둘기','비둘기사진2');
    INSERT INTO user(user_id, user_name, user_nickname, user_img) VALUES('pigeon441','박둘기','둥지없는비둘기','비둘기사진3');

-- 임시로 쓸 테이블들
CREATE TABLE animal_board(
	animal_board_code int PRIMARY KEY AUTO_INCREMENT,
    animal_category_code INT,
    animal_main_image varchar(300),
    animal_board_title varchar(50),
    animal_board_content text,
    animal_board_view int DEFAULT 0,
    animal_board_date TIMESTAMP DEFAULT current_timestamp, 
    user_id VARCHAR(20)
);


CREATE TABLE animal_category(
	animal_category_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_type varchar(20)
);

INSERT INTO animal_category(animal_type) VALUES("개");
INSERT INTO animal_category(animal_type) VALUES("고양이");
INSERT INTO animal_category(animal_type) VALUES("비둘기");
INSERT INTO animal_category(animal_type) VALUES("기타");

CREATE TABLE animal_board_favorite(
	animal_favorite_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    animal_board_code int,
    animal_favorite_date TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE animal_board_image(
	animal_image_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code int,
    animal_board_image varchar(300)
);

CREATE TABLE animal_board_video(
	animal_video_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code int,
    animal_board_videp varchar(300)
);

CREATE TABLE animal_board_comment(
	animal_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code INT,
    user_id VARCHAR(20),
    animal_comment_content varchar(50),
    animal_comment_date TIMESTAMP DEFAULT current_timestamp,
    animal_parent_code INT
);

CREATE TABLE ad(
	ad_code INT PRIMARY KEY AUTO_INCREMENT,
    ad_title VARCHAR(50),
    animal_favorite_code int
);

CREATE TABLE recommand_logic(
	logic_code INT PRIMARY kEY AUTO_INCREMENT,
    category_code INT,
    like_total_hit DOUBLE,
    like_total_lost DOUBLE,
    normal_total_hit DOUBLE,
    normal_total_lost DOUBLE,
    x_total_value DOUBLE
);


ALTER TABLE animal_board ADD FOREIGN KEY (animal_category_code) REFERENCES animal_category (animal_category_code);
ALTER table animal_board ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER table animal_board_favorite ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER table animal_board_favorite ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board(animal_board_code);
ALTER table animal_board_image ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board (animal_board_code);
ALTER table animal_board_video ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board (animal_board_code);
ALTER table animal_board_comment ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board (animal_board_code);
ALTER table animal_board_comment ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER TABLE animal_board_comment ADD FOREIGN KEY (animal_parent_code) REFERENCES animal_board_comment(animal_comment_code);
ALTER TABLE ad ADD FOREIGN KEY(animal_favorite_code) REFERENCES animal_board_favorite(animal_favorite_code);
ALTER TABLE recommand_logic ADD FOREIGN KEY (category_code) REFERENCES animal_category(animal_category_code);