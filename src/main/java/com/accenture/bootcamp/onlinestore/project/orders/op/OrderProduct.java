package com.accenture.bootcamp.onlinestore.project.orders.op;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderProduct {

    private long id;
    private List<Long> productIds = new ArrayList<>();
    private int quantity;
    private long orderId;

    public OrderProduct(){
    }

    public OrderProduct(long id, List<Long> productIds,
                        int quantity, long orderId) {
        this.id = id;
        this.productIds = productIds;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return id == that.id &&
                quantity == that.quantity &&
                orderId == that.orderId &&
                Objects.equals(productIds, that.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productIds, quantity, orderId);
    }
}
