package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private Long id;
    private String imageUri;
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal total;

    public ShoppingCart() {
    }

    public ShoppingCart(Long shoppingCartId, Long id, String imageUri, String name, BigDecimal price, int quantity, BigDecimal total, BigDecimal grandtotal, List<Product> products) {
        this.id = id;
        this.imageUri = imageUri;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(imageUri, that.imageUri) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUri, name, price, quantity, total);
    }
}
