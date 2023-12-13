DROP DATABASE IF EXISTS db_client;
CREATE DATABASE IF NOT EXISTS db_client;
USE db_client;

CREATE TABLE IF NOT EXISTS client
(
	id        BIGINT UNSIGNED AUTO_INCREMENT,
	name      VARCHAR(255)     NOT NULL,
	cpf       VARCHAR(255)     NOT NULL,
	income    DECIMAL(10, 2)   NOT NULL,
	birthDate DATE             NOT NULL,
	children  TINYINT UNSIGNED NOT NULL,

	PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO client (name, cpf, income, birthDate, children) VALUES	('John Doe', '759.382.060-22', 5000.00, '1990-01-15', 2);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES	('Jane Smith', '001.521.140-17', 7000.50, '1985-05-22', 1);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Robert Johnson', '314.088.770-15', 6000.75, '1988-09-10', 0);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Emily White', '761.873.540-95', 8000.20, '1992-03-07', 3);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Michael Brown', '629.888.070-43', 5500.80, '1983-12-18', 2);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Amanda Green', '314.652.990-41', 6500.60, '1995-06-30', 1);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Christopher Davis', '256.414.370-93', 7500.30, '1987-11-25', 0);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Sophia Taylor', '957.908.250-28', 9000.00, '1991-04-14', 2);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Daniel Miller', '092.290.920-29', 4800.90, '1986-08-03', 1);
INSERT INTO client (name, cpf, income, birthDate, children) VALUES 	('Olivia Wilson', '539.163.680-95', 7200.40, '1993-02-28', 3);