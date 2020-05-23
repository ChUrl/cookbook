DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(63)  NOT NULL,
    description VARCHAR(255) NOT NULL,
    body        TEXT         NOT NULL
);
