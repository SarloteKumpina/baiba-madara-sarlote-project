package com.accenture.bootcamp.onlinestore.project.orders.op;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Table(name = "orders_products")
public class OrderProduct {

    //create TABLE orders_products(
    //    id bigint(20) NOT NULL AUTO_INCREMENT,
    //    product_id bigint(20) NOT NULL,
    //    quantity int (11) NOT NULL,
    //    order_id bigint(20) NOT NULL,
    //    PRIMARY KEY (id),
    //    FOREIGN KEY (product_id) REFERENCES products(id),
    //    FOREIGN KEY (order_id) REFERENCES orders(id)
    //);

    @NotEmpty
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "product_id")
    private long productId;

    @NotEmpty
    @Column(name = "quantity")
    private int quantity;

    @NotEmpty
    @Column(name = "order_id")
    private long orderId;

}
