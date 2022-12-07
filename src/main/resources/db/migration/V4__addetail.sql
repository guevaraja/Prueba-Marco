CREATE TABLE IF NOT EXISTS Detail(
    id SERIAL ,
    invoice_id INT NOT NULL ,
    product_id INT NOT NULL NOT NULL,
    quantity INT NOT NULL ,
     FOREIGN KEY (invoice_id) REFERENCES Invoice(id),
     FOREIGN KEY (product_id) REFERENCES Product(id),
     PRIMARY KEY (id)
);
