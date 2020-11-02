CREATE database IF NOT EXISTS sports;

USE sports;

DROP table IF EXISTS sports;
DROP table IF EXISTS teams;


CREATE TABLE sports(
	id INT(8) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)

);

CREATE TABLE teams(
	team_id INT(8) NOT NULL AUTO_INCREMENT,
	location VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	stadium VARCHAR(50),
	division VARCHAR(20),
	sport_id INT(8) NOT NULL,
	PRIMARY KEY(team_id),
	FOREIGN KEY(sport_id) REFERENCES sports(id)

);