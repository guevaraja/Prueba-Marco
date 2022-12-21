

CREATE TABLE IF NOT EXISTS Register(
    id SERIAL,
    member_id INT NOT NULL  ,
    conference_id INT NOT NULL  ,
    code VARCHAR (5) NOT NULL,
    registered_at DATE  NOT NULL ,
    assisted INT NOT NULL
    PRIMARY KEY (id),
    UNIQUE (code),
    FOREIGN KEY (member_id) REFERENCES Member(id)
    FOREIGN KEY (conference_id) REFERENCES Conference(id)
);
