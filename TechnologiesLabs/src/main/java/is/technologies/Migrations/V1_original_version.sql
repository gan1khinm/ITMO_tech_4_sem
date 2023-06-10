CREATE TABLE IF NOT EXISTS brand(
                                    brand_id BIGINT PRIMARY KEY,
                                    brand_name VARCHAR NOT NULL,
                                    date_of_founding DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS model(
                                    model_id BIGINT PRIMARY KEY,
                                    model_name VARCHAR NOT NULL,
                                    model_width INT NOT NULL,
                                    body_type VARCHAR NOT NULL,
                                    brand BIGINT NOT NULL,
                                    CHECK(body_type IN ('лифтбек', 'универсал', 'кабриолет', 'седан', 'хетчбек')),
    FOREIGN KEY (brand) REFERENCES brand (brand_id)
    );

