-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(64)   NOT NULL,
    description VARCHAR(256)  NOT NULL,
    body        VARCHAR(8192) NOT NULL
);

DROP TABLE IF EXISTS recipe_position;

CREATE TABLE recipe_position
(
    id            INT PRIMARY KEY,
    recipe_id     INT REFERENCES recipe (id),
    ingredient_id INT REFERENCES ingredient (id)
);

DROP TABLE IF EXISTS ingredient;

CREATE TABLE ingredient
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    type  VARCHAR(32) NOT NULL
);
