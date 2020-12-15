create TABLE orders(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    customer_id bigint(20) NOT NULL,
    order_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);