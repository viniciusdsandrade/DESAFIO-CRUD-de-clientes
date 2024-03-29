DROP DATABASE IF EXISTS db_client;
CREATE DATABASE IF NOT EXISTS db_client;
USE db_client;

CREATE TABLE IF NOT EXISTS tb_client
(
    id                BIGINT UNSIGNED AUTO_INCREMENT,
    client_name       VARCHAR(255)   NOT NULL,
    client_cpf        VARCHAR(14)    NOT NULL,
    client_income     DECIMAL(10, 2) NOT NULL,
    client_birth_date DATE           NOT NULL,
    client_children   INT            NOT NULL,

    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('John Doe', '759.382.060-22', 5000.00, '1990-01-15', 2);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Jane Smith', '001.521.140-17', 7000.50, '1985-05-22', 1);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Robert Johnson', '314.088.770-15', 6000.75, '1988-09-10', 0);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Emily White', '761.873.540-95', 8000.20, '1992-03-07', 3);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Michael Brown', '629.888.070-43', 5500.80, '1983-12-18', 2);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Amanda Green', '314.652.990-41', 6500.60, '1995-06-30', 1);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Christopher Davis', '256.414.370-93', 7500.30, '1987-11-25', 0);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Sophia Taylor', '957.908.250-28', 9000.00, '1991-04-14', 2);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Daniel Miller', '092.290.920-29', 4800.90, '1986-08-03', 1);
INSERT INTO tb_client (client_name, client_cpf, client_income, client_birth_date, client_children) VALUES ('Olivia Wilson', '539.163.680-95', 7200.40, '1993-02-28', 3);


SELECT * FROM tb_client;