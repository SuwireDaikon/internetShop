package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;


public class ProductBasket {
    private final Map<String, List<Product>> products;


    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("This product does not exist.");
            return;
        }
        products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("The basket is empty.");
            return;
        }

        int specialCounter = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCounter++;
                    }
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
        return products.containsKey(name);
    }

    public void clearBasket() { // PrikolistUdalyator
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            return new LinkedList<>();
        }



        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new LinkedList<>();
    }
}
