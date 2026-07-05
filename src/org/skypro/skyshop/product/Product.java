package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;

public abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();
    public abstract int getPrice();
    public abstract String toString();
}


