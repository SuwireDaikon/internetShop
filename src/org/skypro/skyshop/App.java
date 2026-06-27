package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args)  {
        ProductBasket bTest = new ProductBasket();

        Product waffles = new Product("Waffle", 100);
        Product corn = new Product("Corn", 70);
        Product lamb = new Product("Lamb", 666);
        Product beepBeep = new Product("I'm a Sheep.", 1337);

        bTest.addProduct(waffles);
        bTest.addProduct(corn);
        bTest.printBasket();


        bTest.containsProduct(waffles.getName());
        bTest.containsProduct(lamb.getName());

        putOutliner();

        ProductBasket bTestOverflow = new ProductBasket();
        bTestOverflow.addProduct(waffles);
        bTestOverflow.addProduct(waffles);
        bTestOverflow.addProduct(waffles);
        bTestOverflow.addProduct(waffles);
        bTestOverflow.addProduct(waffles);
        bTestOverflow.addProduct(waffles);
        bTestOverflow.printBasket();

        putOutliner();

        int totalPrice = bTestOverflow.getTotalPrice();
        System.out.println(totalPrice);

        putOutliner();

        boolean found = bTest.containsProduct(waffles.getName());
        if (found) {
            System.out.println("The product was found!");
        } else {
            System.out.println("The product wasn't found, unfortunately...");
        }

        putOutliner();

        boolean found1 = bTest.containsProduct(beepBeep.getName());
        if (found1) {
            System.out.println("The product was found!");
        } else {
            System.out.println("The product wasn't found, unfortunately...");
        }

        putOutliner();

        bTestOverflow.clearBasket();
        bTestOverflow.printBasket();
        bTestOverflow.getTotalPrice();

        putOutliner();

        boolean foundNull = bTest.containsProduct(beepBeep.getName());
        if (foundNull) {
            System.out.println("The product was found!");
        } else {
            System.out.println("The product wasn't found, unfortunately...");
        }
    }

    public static void putOutliner() {
        System.out.println("======================================================================================");
    }
}
