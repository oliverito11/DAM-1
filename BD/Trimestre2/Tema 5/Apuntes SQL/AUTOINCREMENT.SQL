DROP TABLE IF EXISTS AUTO_INC;
CREATE TABLE AUTO_INC
    (COD INT UNIQUE AUTO_INCREMENT,
    VALOR CHAR(1));

INSERT INTO AUTO_INC(VALOR) VALUES('A'), ('B');
SELECT * FROM AUTO_INC;

INSERT INTO AUTO_INC VALUES('CAD', '_');
INSERT INTO AUTO_INC VALUES(NULL, '__');
SELECT * FROM AUTO_INC;