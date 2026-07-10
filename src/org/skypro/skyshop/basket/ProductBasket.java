package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int size;
    private static final int MAX_SIZE = 5;
    //Constructor
    public ProductBasket() {
        this.products = new Product[MAX_SIZE];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("This product does not exist.");
            return;
        }
        if (size < MAX_SIZE) {
            products[size] = product;
            size++;
        } else {
            System.out.println("You've filled the basket! Cannot add anymore...");
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                sum += products[i].getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("The basket is empty.");
            return; // 'cause we don't want to continue
        }

        int specialCounter = 0;

        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                System.out.println(products[i].toString());
                if (products[i].isSpecial()) {
                    specialCounter++;
                }
            }
        }
        System.out.println("Total: " + getTotalPrice());
        System.out.println("Special: " + specialCounter);
    }

    public boolean containsProduct(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (products[i] != null && products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
