package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

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
}


