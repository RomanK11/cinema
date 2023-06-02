--Превьюшка для фильма при нажатии открывает фильм
CREATE TABLE IF NOT EXISTS filmPreview(
    id  IDENTITY NOT NULL PRIMARY KEY,
    title VARCHAR NOT NULL,
    picture VARCHAR NOT NULL,
    theme VARCHAR
);

--Сами фильмы
CREATE TABLE IF NOT EXISTS films(
    id IDENTITY NOT NULL PRIMARY KEY,
    preview_id  BIGINT NOT NULL,
    title VARCHAR NOT NULL,
    link VARCHAR NOT NULL,

    FOREIGN KEY (preview_id) REFERENCES filmPreview(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users(
    id IDENTITY NOT NULL,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);