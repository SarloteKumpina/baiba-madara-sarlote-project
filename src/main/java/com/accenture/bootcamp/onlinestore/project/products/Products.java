package com.accenture.bootcamp.onlinestore.project.products;

import java.util.Objects;

public class Products {

    private long id;
    private String name;
    private long category_id;
    private double price;
    private String description;
    private int stock;
    private String imageUri;

    public Products() {

    }

    public Products(long id, String name, long category_id,
                    double price, String description, int stock, String imageUri) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.imageUri = imageUri;
    }

    public Products(ProductRequest request) {
        this.id = id;
        this.name = request.getName();
        this.category_id = request.getCategory_id();
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

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
        Products products = (Products) o;
        return id == products.id &&
                category_id == products.category_id &&
                Double.compare(products.price, price) == 0 &&
                stock == products.stock &&
                name.equals(products.name) &&
                description.equals(products.description) &&
                imageUri.equals(products.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category_id, price, description, stock, imageUri);
    }
}
