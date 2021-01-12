create database online_shop;

create TABLE categories (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    imageUri varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

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

create TABLE customers (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    phone_number varchar (255) NOT NULL,
    email varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

create TABLE orders(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    customer_id bigint(20) NOT NULL,
    order_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

create TABLE orders_products(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    quantity int (11) NOT NULL,
    order_id bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

create TABLE products_categories (
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id bigint(20) NOT NULL,
    category_id bigint(20) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
