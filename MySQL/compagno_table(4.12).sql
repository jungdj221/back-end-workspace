DROP TABLE notification;

DROP TABLE recommand_logic;
DROP TABLE ad;

DROP TABLE note_file;
DROP TABLE note;

DROP TABLE notice_board_image;
DROP TABLE notice_board_comment;
DROP TABLE notice_board;

DROP TABLE qna_a_board_image;
DROP TABLE qna_a_board;
DROP TABLE qna_q_board_image;
DROP TABLE qna_q_board;

DROP TABLE animal_board_comment;
DROP TABLE animal_board_video;
DROP TABLE animal_board_image;
DROP TABLE animal_board_favorite;
DROP TABLE animal_board;

DROP TABLE oneday_class_board_activity_image;
DROP TABLE oneday_class_board_main_image;
DROP TABLE oneday_class_review_comment;
DROP TABLE oneday_class_review;
DROP TABLE oneday_class_board;

DROP TABLE parsing;

DROP TABLE product_board_recommend;
DROP TABLE product_board_comment;
DROP TABLE product_board_bookmark;
DROP TABLE product_board_image;
DROP TABLE product_board;

DROP TABLE animal_category;

DROP TABLE sitter_board_comment;
DROP TABLE sitter_board_image;
DROP TABLE sitter_board;

DROP TABLE adoption_board_comment;
DROP TABLE adoption_board_image;
DROP TABLE adoption_board;

DROP TABLE lost_board_comment;
DROP TABLE lost_board_image;
DROP TABLE lost_board;

DROP TABLE register_pet_faq;
DROP TABLE register_pet_board;

DROP TABLE user;


-- ======================================== [SH] USER ========================================
-- user
CREATE TABLE user (
	user_id VARCHAR(20) PRIMARY KEY,
    user_person_name VARCHAR(20),
    user_phone VARCHAR(20),
    user_pwd VARCHAR(500),
    user_nickname VARCHAR(20),
    user_email  VARCHAR(50),
    user_status char(1) DEFAULT 'n',
    user_enroll_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_quit_date TIMESTAMP,
    user_role VARCHAR(20) DEFAULT 'ROLE_USER',
    user_img VARCHAR(500),
    user_point INT DEFAULT 0
    );

-- ======================================== [Dana] REGISTER PET ========================================
-- register_pet_board
CREATE TABLE register_pet_board(
	rp_board_code INT PRIMARY KEY AUTO_INCREMENT,
    rp_inst_name VARCHAR(100),
    rp_inst_addr VARCHAR(200),
    rp_inst_owner VARCHAR(20),
    rp_inst_phone VARCHAR(20)
);

-- register_pet_faq
CREATE TABLE register_pet_faq(
	rp_faq_code INT PRIMARY KEY AUTO_INCREMENT,
    rp_faq_question VARCHAR(200),
    rp_faq_answer text,
    rp_faq_status CHAR(1) CHECK (rp_faq_status IN ('Y', 'N')) DEFAULT 'Y'
);

-- ======================================== [MJ] LOST ========================================
-- lost_board
CREATE TABLE lost_board(
	lost_board_code	INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    user_img VARCHAR(500),
    user_phone VARCHAR(20),
    lost_title VARCHAR(50) NOT NULL,
    lost_regi_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    lost_view_count INT DEFAULT 0,
    lost_animal_image VARCHAR(150),
    lost_animal_name VARCHAR(30) NOT NULL,
    lost_date DATE NOT NULL,
    lost_location VARCHAR(50) NOT NULL,
    lost_animal_kind VARCHAR(30),
    lost_animal_color VARCHAR(30),
    lost_animal_gender VARCHAR(10) CHECK (lost_animal_gender IN ('수컷', '암컷', '모름')) DEFAULT '수컷',
    lost_animal_age INT,
    lost_animal_feature TEXT NOT NULL,
    lost_animal_RFID INT
);

-- lost_board_image
CREATE TABLE lost_board_image(
	lost_image_code INT PRIMARY KEY AUTO_INCREMENT,
    lost_board_code INT,
    lost_image VARCHAR(300)
);

-- lost_board_comment
CREATE TABLE lost_board_comment(
	lost_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    lost_board_code INT,
    user_id VARCHAR(20),
    user_img VARCHAR(500),
    user_nickname VARCHAR(20),
    comment_content TEXT NOT NULL,
    comment_date TIMESTAMP DEFAULT current_timestamp NOT NULL,
    lost_parent_code INT
);

-- ======================================== [MJ] ADOPTION ========================================
-- adoption_board
CREATE TABLE adoption_board(
	adoption_board_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    user_img VARCHAR(500),
    adoption_title VARCHAR(50) NOT NULL,
    adoption_regi_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    adoption_view_count INT DEFAULT 0,
    adoption_animal_image VARCHAR(150) NOT NULL,
    adoption_animal_kind VARCHAR(30),
    adoption_animal_color VARCHAR(30) NOT NULL,
    adoption_animal_findplace VARCHAR(30) NOT NULL,
    adoption_animal_gender VARCHAR(10) CHECK (adoption_animal_gender IN ('수컷', '암컷', '모름')) DEFAULT '수컷',
    adoption_animal_neuter CHAR(1) CHECK (adoption_animal_neuter IN ('Y', 'N')) DEFAULT 'N',
    adoption_animal_age INT,
    adoption_animal_kg INT NOT NULL,
    adoption_animal_feature TEXT NOT NULL,
    adoption_animal_center VARCHAR(30) NOT NULL,
    adoption_animal_place VARCHAR(100) NOT NULL,
    adoption_animal_phone VARCHAR(20) NOT NULL
);

-- adoption_board_image
CREATE TABLE adoption_board_image(
	adoption_image_code INT PRIMARY KEY AUTO_INCREMENT,
    adoption_board_code INT,
    adoption_image VARCHAR(300)
);

-- adoption_board_comment
CREATE TABLE adoption_board_comment(
	adoption_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    adoption_board_code INT,
    user_id VARCHAR(20),
    user_img VARCHAR(500),
    comment_content TEXT NOT NULL,
    comment_date TIMESTAMP NOT NULL,
    adoption_parent_code INT
);

-- ======================================== [Dana] SITTER ========================================
-- sitter_board
CREATE TABLE sitter_board(
	sitter_board_code INT PRIMARY KEY AUTO_INCREMENT,
    sitter_category VARCHAR(50) NOT NULL,
	sitter_location VARCHAR(100) NOT NULL,
    sitter_title VARCHAR(100) NOT NULL,
    sitter_content TEXT NOT NULL,
    user_id VARCHAR(20),
    sitter_view_count INT DEFAULT 0,
    sitter_regi_date DATETIME DEFAULT now(),
    sitter_update_date DATE,
    sitter_status CHAR(1) CHECK (sitter_status IN ('Y', 'N')) DEFAULT 'Y'
);

-- sitter_board_image
CREATE TABLE sitter_board_image(
	sitter_image_code INT PRIMARY KEY AUTO_INCREMENT,
    sitter_board_code INT,
    sitter_bd_image	VARCHAR(200)
);

-- sitter_board_comment
CREATE TABLE sitter_board_comment(
	sitter_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    sitter_board_code INT,
    user_id VARCHAR(20),
    sitter_com_content TEXT NOT NULL,
    sitter_com_regi_date DATETIME DEFAULT now(),
    sitter_com_status CHAR(1) CHECK(sitter_com_status IN ('Y', 'N')) DEFAULT 'Y',
    sitter_com_delete_date DATE,
    sitter_com_parent_code INT
);

-- ======================================== [HY] PRODUCT ========================================
-- product_board
CREATE TABLE product_board(
	product_board_code INT PRIMARY KEY AUTO_INCREMENT,
    product_board_title	VARCHAR(50) NOT NULL,
    product_main_image VARCHAR(150),
    product_name VARCHAR(40) NOT NULL,
    product_price INT NOT NULL,
    product_category VARCHAR(20),
    animal_category_code INT,
    product_board_grade DECIMAL(2,1) NOT NULL,
    product_board_content TEXT NOT NULL,
    product_board_regi_date DATETIME DEFAULT now(),
    user_id VARCHAR(20),
    product_board_view_count INT DEFAULT 0
);

-- product_board_image
CREATE TABLE product_board_image(
	product_image_code INT PRIMARY KEY AUTO_INCREMENT,
    product_board_code INT,
    product_image VARCHAR(150) NOT NULL
);

-- product_board_comment
CREATE TABLE product_board_comment(
	product_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    product_board_code INT,
    user_id VARCHAR(20),
    product_comment_content TEXT NOT NULL,
    product_comment_regi_date DATETIME DEFAULT now(),
    product_parent_code INT,
    product_comment_delete CHAR(1) CHECK (product_comment_delete IN ('Y', 'N')) DEFAULT 'N'
);

-- product_board_recommend
CREATE TABLE product_board_recommend(
	product_recommend_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    product_board_code INT,
    product_recommend_date DATETIME DEFAULT now()
);

-- product_board_bookmark
CREATE TABLE product_board_bookmark(
	product_bookmark_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    product_board_code INT
);

-- ======================================== [HS] ONEDAY CLASS ========================================
-- oneday_class_board
CREATE TABLE oneday_class_board(
	odc_code INT PRIMARY KEY AUTO_INCREMENT,
    odc_title VARCHAR(200) NOT NULL,
    odc_content TEXT NOT NULL,
    odc_accompaying CHAR(1) CHECK (odc_accompaying IN ('Y', 'N')) DEFAULT 'Y',
    odc_regi_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    odc_start_date DATE NOT NULL,
    odc_last_date DATE NOT NULL,
    user_id VARCHAR(20)
);

CREATE TABLE oneday_class_board_main_image(
	odc_image_code INT PRIMARY KEY AUTO_INCREMENT,
    odc_code INT,
    odc_main_image VARCHAR(200) NOT NULL,
    user_id INT
);

CREATE TABLE oneday_class_board_activity_image(
	odc_active_image_code INT PRIMARY KEY AUTO_INCREMENT,
    odc_code INT,
    odc_active_image VARCHAR(200) NOT NULL,
    user_id INT
);

-- oneday_class_review
CREATE TABLE oneday_class_review(
	odc_review_code INT PRIMARY KEY AUTO_INCREMENT,
    odc_code INT,
    odc_review_title VARCHAR(20) NOT NULL,
    odc_review_content TEXT NOT NULL,
    odc_review_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    odc_review_count INT NOT NULL,
    user_id VARCHAR(20)
);

CREATE TABLE oneday_class_review_comment(
	odc_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    odc_code INT,
    odc_review_code INT,
    odc_comment_context VARCHAR(50) NOT NULL,
    odc_comment_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    odc_parent_code INT NOT NULL,
    user_id VARCHAR(20)
);

-- ======================================== [J] ANIMAL ========================================
CREATE TABLE animal_board(
	animal_board_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_category_code INT,
    animal_main_image VARCHAR(300),
    animal_board_title VARCHAR(50),
    animal_board_content TEXT,
    animal_board_view INT DEFAULT 0,
    animal_board_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    user_id VARCHAR(20)
);

-- animal_category
CREATE TABLE animal_category(
	animal_category_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_type VARCHAR(20)
);

INSERT INTO animal_category(animal_type) VALUES("개");
INSERT INTO animal_category(animal_type) VALUES("고양이");
INSERT INTO animal_category(animal_type) VALUES("비둘기");
INSERT INTO animal_category(animal_type) VALUES("기타");

-- favorite
CREATE TABLE animal_board_favorite(
	animal_favorite_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    animal_board_code INT,
    animal_favorite_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE animal_board_image(
	animal_image_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code INT,
    animal_board_image VARCHAR(300)
);

CREATE TABLE animal_board_video(
	animal_video_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code INT,
    animal_board_videp VARCHAR(300)
);

CREATE TABLE animal_board_comment(
	animal_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    animal_board_code INT,
    user_id VARCHAR(20),
    animal_comment_content VARCHAR(50),
    animal_comment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    animal_parent_code INT
);

-- ======================================== [YB] PARSING ========================================
CREATE TABLE parsing(
	num INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    main_cate VARCHAR(20),
    main_cate_code INT,
    sub_cate VARCHAR(20),
    sub_cate_code INT,
    mainreg_cate VARCHAR(20),
    mainreg_code INT,
    subreg_cate VARCHAR(100),
	latitude VARCHAR(100),
    longtitude VARCHAR(100),
    road_addr VARCHAR(100),
    addr VARCHAR(100),
    phone  VARCHAR(30),
    url VARCHAR(500),
    parking VARCHAR(30),
    fee VARCHAR(100)
);

-- ======================================== [YB] QNA ========================================
-- qna_question
CREATE TABLE qna_q_board(
	qna_q_board_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    user_nickname VARCHAR(20),
    qna_q_title VARCHAR(30) NOT NULL,
    qna_q_content TEXT NOT NULL,
    qna_q_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp,
    qna_q_status CHAR(1) CHECK(qna_q_status IN ('Y', 'N')) DEFAULT 'N'
);

CREATE TABLE qna_q_board_image(
	qna_q_board_img_code INT PRIMARY KEY AUTO_INCREMENT,
    qna_q_board_code INT,
    qna_q_board_url VARCHAR(300)
);

-- qna_answer
CREATE TABLE qna_a_board(
	qna_a_code INT PRIMARY KEY AUTO_INCREMENT,
	qna_q_board_code INT,
    user_id VARCHAR(20),
    qna_a_title VARCHAR(30) NOT NULL,
    qna_a_content TEXT NOT NULL,
    qna_a_date TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp
);

CREATE TABLE qna_a_board_image(
	qna_a_img_code INT PRIMARY KEY AUTO_INCREMENT,
    qna_a_code INT,
    qna_a_url VARCHAR(300)
);

-- ======================================== [HY] NOTICE ========================================
CREATE TABLE notice_board(
	notice_board_code INT PRIMARY KEY AUTO_INCREMENT,
    notice_board_title VARCHAR(50) NOT NULL,
    notice_board_content TEXT NOT NULL,
    notice_board_regi_date DATETIME DEFAULT now(),
    user_id VARCHAR(20),
    notice_board_hits INT DEFAULT 0
);

CREATE TABLE notice_board_comment(
	notice_comment_code INT PRIMARY KEY AUTO_INCREMENT,
    notice_board_code INT,
    user_id VARCHAR(20) NOT NULL,
    notice_comment_content TEXT NOT NULL,
    notice_comment_regi_date DATETIME DEFAULT now(),
    notice_parent_code INT DEFAULT 0,
    notice_comment_delete CHAR(1) CHECK (notice_comment_delete IN ('Y', 'N')) DEFAULT 'N'
);

CREATE TABLE notice_board_image(
	notice_image_code INT PRIMARY KEY AUTO_INCREMENT,
    notice_board_code INT,
    notice_image VARCHAR(150)
);

-- ======================================== [MJ] NOTE ========================================
CREATE TABLE note(
	note_code INT PRIMARY KEY AUTO_INCREMENT,
    note_title VARCHAR(100) NOT NULL,
    note_content TEXT NOT NULL,
    sender VARCHAR(20) NOT NULL,
    receiver VARCHAR(20) NOT NULL,
    note_regi_date DATE DEFAULT (current_date),
    deleted_by_sender BOOLEAN DEFAULT false,
    deleted_by_receiver BOOLEAN DEFAULT false
);

CREATE TABLE note_file(
	note_file_code INT PRIMARY KEY AUTO_INCREMENT,
    note_code INT NOT NULL,
    note_file_url VARCHAR(300)
);

-- ======================================== [J] AD ========================================
CREATE TABLE ad(
	ad_code INT PRIMARY KEY AUTO_INCREMENT,
    ad_title VARCHAR(50),
    animal_favorite_code INT
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

-- ======================================== [Dana] NOTIFICATION ========================================
CREATE TABLE notification(
	noti_code INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(20),
    noti_date TIMESTAMP DEFAULT current_timestamp,
    noti_category VARCHAR(100) NOT NULL
);


ALTER TABLE lost_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
-- ALTER TABLE lost_board ADD FOREIGN KEY (user_img) REFERENCES user(user_img);
-- ALTER TABLE lost_board ADD FOREIGN KEY (user_phone) REFERENCES user(user_phone);
ALTER TABLE lost_board_image ADD FOREIGN KEY (lost_board_code) REFERENCES lost_board(lost_board_code);
ALTER TABLE lost_board_comment ADD FOREIGN KEY (lost_board_code) REFERENCES lost_board(lost_board_code);
ALTER TABLE lost_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
-- ALTER TABLE lost_board_comment ADD FOREIGN KEY (user_img) REFERENCES user(user_img);
-- ALTER TABLE lost_board_comment ADD FOREIGN KEY (user_nickname) REFERENCES user(user_nickname);
ALTER TABLE lost_board_comment ADD FOREIGN KEY (lost_parent_code) REFERENCES lost_board_comment(lost_comment_code);

ALTER TABLE adoption_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
-- ALTER TABLE adoption_board ADD FOREIGN KEY (user_img) REFERENCES user(user_img);
ALTER TABLE adoption_board_image ADD FOREIGN KEY (adoption_board_code) REFERENCES adoption_board(adoption_board_code);
ALTER TABLE adoption_board_comment ADD FOREIGN KEY (adoption_board_code) REFERENCES adoption_board(adoption_board_code);
ALTER TABLE adoption_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
-- ALTER TABLE adoption_board_comment ADD FOREIGN KEY (user_img) REFERENCES user(user_img);
ALTER TABLE adoption_board_comment ADD FOREIGN KEY (adoption_parent_code) REFERENCES adoption_board_comment(adoption_comment_code);

ALTER TABLE sitter_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE sitter_board_image ADD FOREIGN KEY (sitter_board_code) REFERENCES sitter_board(sitter_board_code);
ALTER TABLE sitter_board_comment ADD FOREIGN KEY (sitter_board_code) REFERENCES sitter_board(sitter_board_code);
ALTER TABLE sitter_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE sitter_board_comment ADD FOREIGN KEY (sitter_com_parent_code) REFERENCES sitter_board_comment(sitter_comment_code);

ALTER TABLE product_board ADD FOREIGN KEY (animal_category_code) REFERENCES animal_category(animal_category_code);
ALTER TABLE product_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE product_board_image ADD FOREIGN KEY (product_board_code) REFERENCES product_board(product_board_code);
ALTER TABLE product_board_comment ADD FOREIGN KEY (product_board_code) REFERENCES product_board(product_board_code);
ALTER TABLE product_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE product_board_comment ADD FOREIGN KEY (product_parent_code) REFERENCES product_board_comment(product_comment_code);
ALTER TABLE product_board_recommend ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE product_board_recommend ADD FOREIGN KEY (product_board_code) REFERENCES product_board(product_board_code);
ALTER TABLE product_board_bookmark ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE product_board_bookmark ADD FOREIGN KEY (product_board_code) REFERENCES product_board(product_board_code);

ALTER TABLE oneday_class_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE oneday_class_board_main_image ADD FOREIGN KEY (odc_code) REFERENCES oneday_class_board(odc_code);
-- ALTER TABLE oneday_class_board_main_image ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE oneday_class_board_activity_image ADD FOREIGN KEY (odc_code) REFERENCES oneday_class_board(odc_code);
-- ALTER TABLE oneday_class_board_activity_image ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE oneday_class_review ADD FOREIGN KEY (odc_code) REFERENCES oneday_class_board(odc_code);
ALTER TABLE oneday_class_review ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE oneday_class_review_comment ADD FOREIGN KEY (odc_code) REFERENCES oneday_class_board(odc_code);
ALTER TABLE oneday_class_review_comment ADD FOREIGN KEY (odc_review_code) REFERENCES oneday_class_review(odc_review_code);
-- ALTER TABLE oneday_class_reivew_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);

ALTER TABLE animal_board ADD FOREIGN KEY (animal_category_code) REFERENCES animal_category(animal_category_code);
ALTER TABLE animal_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE animal_board_favorite ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE animal_board_favorite ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board(animal_board_code);
ALTER TABLE animal_board_image ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board(animal_board_code);
ALTER TABLE animal_board_video ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board(animal_board_code);
ALTER TABLE animal_board_comment ADD FOREIGN KEY (animal_board_code) REFERENCES animal_board(animal_board_code);
ALTER TABLE animal_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE animal_board_comment ADD FOREIGN KEY (animal_parent_code) REFERENCES animal_board_comment(animal_comment_code);

ALTER TABLE qna_q_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
-- ALTER TABLE qna_q_board ADD FOREIGN KEY (user_nickname) REFERENCES user(user_nickname);
ALTER TABLE qna_q_board_image ADD FOREIGN KEY (qna_q_board_code) REFERENCES qna_q_board(qna_q_board_code);
ALTER TABLE qna_a_board ADD FOREIGN KEY (qna_q_board_code) REFERENCES qna_q_board(qna_q_board_code);
ALTER TABLE qna_a_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE qna_a_board_image ADD FOREIGN KEY (qna_a_code) REFERENCES qna_a_board(qna_a_code);

ALTER TABLE notice_board ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE notice_board_comment ADD FOREIGN KEY (notice_board_code) REFERENCES notice_board(notice_board_code);
ALTER TABLE notice_board_comment ADD FOREIGN KEY (user_id) REFERENCES user(user_id);
ALTER TABLE notice_board_comment ADD FOREIGN KEY (notice_parent_code) REFERENCES notice_board_comment(notice_comment_code);
ALTER TABLE notice_board_image ADD FOREIGN KEY (notice_board_code) REFERENCES notice_board(notice_board_code);

ALTER TABLE note_file ADD FOREIGN KEY (note_code) REFERENCES note(note_code);

ALTER TABLE ad ADD FOREIGN KEY(animal_favorite_code) REFERENCES animal_board_favorite(animal_favorite_code);
ALTER TABLE recommand_logic ADD FOREIGN KEY (category_code) REFERENCES animal_category(animal_category_code);

ALTER TABLE notification ADD FOREIGN KEY (user_id) REFERENCES user(user_id);