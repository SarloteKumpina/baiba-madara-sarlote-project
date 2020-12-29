package com.accenture.bootcamp.onlinestore.project.orders.op;

import java.util.List;

public interface OrderProductRepository {
    OrderProduct findOne(long id);

    List<OrderProduct> findAll();

    void delete(long id);
}
