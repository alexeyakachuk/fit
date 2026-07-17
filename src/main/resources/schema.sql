DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PRODUCTS;
-- DROP TABLE IF EXISTS USER_MEALS

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

-- Таблица пользователя
CREATE TABLE IF NOT EXISTS USERS (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(256) UNIQUE NOT NULL,
    email VARCHAR(256) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- Таблица продуктов
CREATE TABLE IF NOT EXISTS PRODUCTS (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_type VARCHAR(256) NOT NULL,
    product_name VARCHAR(256) UNIQUE NOT NULL,
    calories INTEGER NOT NULL,
    proteins DECIMAL(5,2) NOT NULL,
    fat DECIMAL(5,2) NOT NULL,
    carbohydrates DECIMAL(5,2) NOT NULL
);

-- Таблица Еда пользователя
CREATE TABLE IF NOT EXISTS USER_MAILS (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    amount_grams INTEGER NOT NULL CHECK (amount_grams > 0),
    meal_type VARCHAR(20) NOT NULL CHECK (meal_type IN ('Завтрак', 'Обед', 'Ужин', 'Перекус')),
    meal_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS(id),
    FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
);