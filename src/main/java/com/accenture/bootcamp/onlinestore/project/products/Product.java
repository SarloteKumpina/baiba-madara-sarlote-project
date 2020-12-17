package com.accenture.bootcamp.onlinestore.project.products;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private long CategoryId;
    private BigDecimal price;
    private String description;
    private int stock;
    private String imageUri;

    public Product() {

    }

    public Product(long id, String name, long CategoryId,
                   BigDecimal price, String description, int stock, String imageUri) {
        this.id = id;
        this.name = name;
        this.CategoryId = CategoryId;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.imageUri = imageUri;
    }

    public Product(ProductRequest request) {
        this.id = id;
        this.name = request.getName();
        this.CategoryId = request.getCategoryId();
        this.price = request.getPrice();
        this.description = request.getDescription();
        this.stock = request.getStock();
        this.imageUri = request.getImageUri();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(long categoryId) {
        this.CategoryId = categoryId;
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return id == products.id &&
                CategoryId == products.CategoryId &&
                stock == products.stock &&
                name.equals(products.name) &&
                price.equals(products.price) &&
                description.equals(products.description) &&
                imageUri.equals(products.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, CategoryId, price, description, stock, imageUri);
    }
}
