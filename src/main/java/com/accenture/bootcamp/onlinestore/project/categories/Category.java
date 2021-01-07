package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {

    private long id;
    private String name;
    private String imageUri;

    public Category() {
    }

    public Category(long id, String name, String imageUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
    }

//    public Category(CategoryRequest request) {
//        this.id = id;
//        this.name = request.getName();
//        this.imageUri = request.getImageUri();
//    }

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

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @ManyToMany
    private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return id == that.id &&
                name.equals(that.name) &&
                imageUri.equals(that.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUri);
    }
}
