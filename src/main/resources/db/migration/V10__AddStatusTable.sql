create TABLE status(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE orders
ADD status_id int(11);

ALTER TABLE orders
ADD FOREIGN KEY (status_id) REFERENCES status(id);