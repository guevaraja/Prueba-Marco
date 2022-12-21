CREATE TABLE IF NOT EXISTS (
    id SERIAL ,
    nombres VARCHAR(100) ,
    email VARCHAR (50) NOT NULL,
    institucion VARCHAR(100),
    cargo VARCHAR(100),
    PRIMARY KEY (id),
    UNIQUE (email)
);