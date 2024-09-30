SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS FOOD_RATE_INFO;
DROP TABLE IF EXISTS FOOD_INFO;
DROP TABLE IF EXISTS CATEGORY_INFO;




/* Create Tables */

CREATE TABLE CATEGORY_INFO
(
	CAI_NUM int NOT NULL AUTO_INCREMENT,
	CAI_NAME varchar(30) NOT NULL,
	CAI_DESC varchar(4000),
	CREDAT char(8) DEFAULT DATE_FORMAT(NOW(),'%Y%m%d'),
	CRETIM char(6) DEFAULT DATE_FORMAT(NOW(),'%H%i%s'),
	PRIMARY KEY (CAI_NUM),
	UNIQUE (CAI_NAME)
);


CREATE TABLE FOOD_INFO
(
	FOI_NUM int NOT NULL AUTO_INCREMENT,
	FOI_NAME varchar(30) NOT NULL,
	FOI_PRICE int unsigned DEFAULT 0,
	FOI_IMG_PATH varchar(30) NOT NULL,
	FOI_SUMMARY varchar(4000) NOT NULL,
	FOI_DESC text,
	CREDAT char(8) DEFAULT DATE_FORMAT(NOW(),'%Y%m%d'),
	CRETIM char(6) DEFAULT DATE_FORMAT(NOW(),'%H%i%s'),
	CAI_NUM int NOT NULL,
	PRIMARY KEY (FOI_NUM),
	UNIQUE (FOI_NAME)
);


CREATE TABLE FOOD_RATE_INFO
(
	FRI_NUM int NOT NULL AUTO_INCREMENT,
	FRI_NAME varchar(50) NOT NULL,
	FRI_COMMENT varchar(4000) NOT NULL,
	FRI_RATE tinyint unsigned NOT NULL,
	CREDAT char(8) DEFAULT DATE_FORMAT(NOW(),'%Y%m%d'),
	CRETIM char(6) DEFAULT DATE_FORMAT(NOW(),'%H%i%s'),
	FOI_NUM int NOT NULL,
	PRIMARY KEY (FRI_NUM)
);



/* Create Foreign Keys */

ALTER TABLE FOOD_INFO
	ADD FOREIGN KEY (CAI_NUM)
	REFERENCES CATEGORY_INFO (CAI_NUM)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FOOD_RATE_INFO
	ADD FOREIGN KEY (FOI_NUM)
	REFERENCES FOOD_INFO (FOI_NUM)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



