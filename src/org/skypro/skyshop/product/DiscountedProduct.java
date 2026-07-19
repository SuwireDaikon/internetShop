package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero (0)!");
        }
        this.price = price;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Percent is the number between zero and hundred, but can't be less than zero or greater than hundred");
        }
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
       return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
