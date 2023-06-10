CREATE TABLE IF NOT EXISTS users(
                                    id BIGINT PRIMARY KEY,
                                    username VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(20) default 'USER'
    );