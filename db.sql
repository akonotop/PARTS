USE testone;

CREATE TABLE parts
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL ,
    importance BIT DEFAULT false NOT NULL,
    count int(4)
)
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX parts_name_uindex ON parts (name);

INSERT INTO `parts` (`name`, importance, `count`)
VALUES
("материнская плата", 1, 12),
("звуковая карта", 0, 5),
("процессор", 1, 10),
("подсветка корпуса", 0, 3),
("HDD диск", 0, 4),
("корпус", 1, 5),
("память", 1, 7),
("SSD иск", 1, 8),
("видеокарта", 0, 7),
("CD-ROM", 0, 6),
("DVD-ROM", 0, 12),
("мышка", 0, 5),
("монитор", 0, 16),
("клавиатура", 0, 34),
("WEB-камера", 0, 25),
("блок-питания", 1, 7),
("вентилятор", 1, 53),
("TV-тюнер", 0, 14),
("WI-FI", 1, 58),
("сетевая карта", 0, 58);
("колонки", 0, 23);
("GPS", 0, 12);
("принтер", 0, 3);