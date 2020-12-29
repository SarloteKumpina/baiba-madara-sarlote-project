package com.accenture.bootcamp.onlinestore.project.orders;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
@Table(name = "orders")
public class Order {

    //create TABLE orders(
    //    id bigint(20) NOT NULL AUTO_INCREMENT,
    //    customer_id bigint(20) NOT NULL,
    //    order_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    //    PRIMARY KEY (id),
    //    FOREIGN KEY (customer_id) REFERENCES customers(id)
    //);

    @NotEmpty
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "customer_id")
    private long customerId;

    @NotEmpty
    @Column(name = "order_time")
    private Timestamp orderTime;

}
