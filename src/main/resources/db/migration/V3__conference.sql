CREATE TABLE IF NOT EXISTS Conference(
    id SERIAL ,
    title VARCHAR(100) ,
    speaker VARCHAR (30) NOT NULL,
    hour INT NOT NULL,
    day DATE ,
    totalAttendees VARCHAR (20),
    event_id INT NOT NULL,
    FOREIGN KEY (EVENT_id) REFERENCES Event(id)
    PRIMARY KEY (id)

);
