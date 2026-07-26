package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products;


    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("This product does not exist.");
            return;
        }
        products.add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPrice();
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

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
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
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() { // PrikolistUdalyator
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            return new LinkedList<>();
        }

        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && name.equals(product.getName())) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}
