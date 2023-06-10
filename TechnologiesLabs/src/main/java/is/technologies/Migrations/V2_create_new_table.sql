ALTER TABLE model ADD COLUMN model_height INT;

CREATE TABLE IF NOT EXISTS engine(
                                     engine_id BIGINT PRIMARY KEY,
                                     engine_name VARCHAR NOT NULL,
                                     engine_volume INT NOT NULL,
                                     cylinders_amount INT NOT NUll,
                                     engine_height INT NOT NULL,
                                     car_model BIGINT NOT NULL,
                                     FOREIGN KEY (car_model) REFERENCES model (model_id)
);