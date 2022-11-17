

CREATE TABLE IF NOT EXISTS invoice(
    id SERIAL,
    asistente_id INT NOT NULL  ,
    code VARCHAR (50) NOT NULL,
    create_at DATE  NOT NULL ,
    total DECIMAL (8,2),
    PRIMARY KEY (id),
    UNIQUE (code),
    FOREIGN KEY (asistente_id) REFERENCES Asistente(id)
);
