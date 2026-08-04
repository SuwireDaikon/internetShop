package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product's name cannot be blank or null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();
    public abstract int getPrice();
    public abstract String toString();

    @Override
    public String getSearchTerm() {
        return name;
    }
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name, product.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


