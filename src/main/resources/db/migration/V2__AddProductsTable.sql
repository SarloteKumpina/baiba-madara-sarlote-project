create TABLE products (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    category_id bigint(20) NOT NULL,
    price decimal(3,2) NOT NULL,
    description varchar(1000) NOT NULL,
    stock int(11),
    imageUri varchar(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);