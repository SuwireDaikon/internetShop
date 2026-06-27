package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
/*
    LISTEN, YOU DO NOT SEE THESE SETTERS.
    public void setName(String newName) {
        this.name = newName;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
    THERE IS NOTHING HERE.
    btw, Т-09-82 is the way to survive this (there is a nuance, though).
*/
}
