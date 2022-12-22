CREATE TABLE IF NOT EXISTS Product(
    id SERIAL ,
    description VARCHAR(100) ,
    brand VARCHAR (30) NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY (id)

);
