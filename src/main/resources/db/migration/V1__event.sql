CREATE TABLE IF NOT EXISTS Event (
    id SERIAL ,
    description VARCHAR(75) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL ,
    total_attendees DECIMAL(100,0),
    city VARCHAR (25) NOT NULL,
    PRIMARY KEY (id),

);
