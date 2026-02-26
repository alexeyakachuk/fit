DROP TABLE IF EXISTS USERS;

--Создание таблицы users
-- CREATE TABLE IF NOT EXISTS "USER" (
--     id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     userName VARCHAR(256) UNIQUE NOT NULL,
--     email VARCHAR(256) UNIQUE NOT NULL,
--     password VARCHAR(256) NOT NULL,
--     --Отслеживает когда пользователь зарегестрировался
--     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
--     --Отслеживает когда пользователь делал изменения в профиле
--     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
-- );

CREATE TABLE IF NOT EXISTS "USER" (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(256) UNIQUE NOT NULL,
    email VARCHAR(256) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );