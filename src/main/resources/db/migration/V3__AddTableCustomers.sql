create TABLE customers (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    phone_number varchar (255) NOT NULL,
    email varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    PRIMARY KEY (id)
);