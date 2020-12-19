create TABLE products_categories(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    category_id bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);