-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe
(
    id          INT AUTO_INCREMENT,
    title       VARCHAR(64)   NOT NULL,
    description VARCHAR(256)  NOT NULL,
    body        VARCHAR(8192) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ingredient;

CREATE TABLE ingredient
(
    id    INT AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    type  VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS recipe_ingredient;

CREATE TABLE recipe_ingredient
(
    recipe     INT NOT NULL,
    ingredient INT NOT NULL,
    PRIMARY KEY (recipe, ingredient)
);
