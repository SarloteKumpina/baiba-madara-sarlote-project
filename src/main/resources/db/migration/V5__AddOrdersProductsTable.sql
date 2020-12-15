create TABLE orders_products(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    quantity int (11) NOT NULL,
    order_id bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);