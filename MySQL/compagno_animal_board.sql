CREATE TABLE animal_board(
	a_board_code int PRIMARY KEY AUTO_INCREMENT,
    animal_category_code int,
    a_main_image varchar(300),
    a_board_title varchar(50),
    a_board_content text,
    a_board_view int DEFAULT 0,
    a_board_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_code int
);

CREATE TABLE animal_category(
	aniaml_category_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_type varchar(20)
);

CREATE TABLE animal_board_favorite(
	a_favorite_code INT PRIMARY KEY AUTO_INCREMENT,
    user_code int,
    a_board_code int,
    a_favorite_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE animal_board_image(
	a_image_code INT PRIMARY KEY AUTO_INCREMENT,
    a_board_code int,
    a_board_image varchar(300)
);

CREATE TABLE animal_board_video(
	a_video_code INT PRIMARY KEY AUTO_INCREMENT,
    a_board_code int,
    a_board_videp varchar(300)
);

CREATE TABLE animal_board_comment(
	a_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    a_board_code INT,
    user_code INT,
    a_comment_content varchar(50),
    a_comment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    a_parent_code INT
);

CREATE TABLE ad(
	ad_code INT PRIMARY KEY AUTO_INCREMENT,
    ad_title VARCHAR(50),
    a_favorite_code int
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

ALTER TABLE animal_board ADD FOREIGN KEY (annimal_category_code) REFERENCES animal_category(animal_category_code);
ALTER table animal_board ADD FOREIGN KEY (user_code) REFERENCES user (user_code);
ALTER table animal_board_favorite ADD FOREIGN KEY (user_code) REFERENCES user (user_code);
ALTER table animal_board_favorite ADD FOREIGN KEY (a_board_code) REFERENCES animal_board(a_board_code);
ALTER table animal_board_image ADD FOREIGN KEY (a_board_code) REFERENCES animal_board (a_board_code);
ALTER table animal_board_video ADD FOREIGN KEY (a_board_code) REFERENCES animal_board (a_board_code);
ALTER table animal_board_comment ADD FOREIGN KEY (a_board_code) REFERENCES animal_board (a_board_code);
ALTER table animal_board_comment ADD FOREIGN KEY (user_code) REFERENCES user (user_code);
ALTER TABLE animal_board_comment ADD FOREIGN KEY (a_parent_code) REFERENCES animal_board_comment(a_comment_code);
ALTER TABLE ad ADD FOREIGN KEY(a_favorite_code) REFERENCES animal_board_favorite(a_favorite_code);
ALTER TABLE recommand_logic ADD FOREIGN KEY (category_code) REFERENCES product_board (animal_category_code);