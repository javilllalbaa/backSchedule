CREATE TABLE
IF NOT EXISTS schedule (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	description VARCHAR(1024),
	duration_minutes BIGINT,
	color_hex_code VARCHAR(255),
	PRIMARY KEY (id)
);