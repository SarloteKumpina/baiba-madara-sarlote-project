package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private Long shoppingCartId;
    private Long id;
    private String imageUri;
    private String name;
    private BigDecimal price;
    private int quantity;
    private double total;
    private double grandtotal;

    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Long shoppingCartId, Long id, String imageUri, String name, BigDecimal price, int quantity, double total, double grandtotal, List<Product> products) {
        this.shoppingCartId = shoppingCartId;
        this.id = id;
        this.imageUri = imageUri;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.grandtotal = grandtotal;
        this.products = products;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return quantity == that.quantity &&
                Double.compare(that.total, total) == 0 &&
                Double.compare(that.grandtotal, grandtotal) == 0 &&
                Objects.equals(shoppingCartId, that.shoppingCartId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(imageUri, that.imageUri) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId, id, imageUri, name, price, quantity, total, grandtotal, products);
    }
}
