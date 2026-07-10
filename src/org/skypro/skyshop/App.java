package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args)  {
        ProductBasket bTest = new ProductBasket();

        Product waffles = new SimpleProduct("Waffle", 100);
        Product corn = new SimpleProduct("Corn", 70);
        Product lamb = new SimpleProduct("Lamb", 666);
        Product beepBeep = new SimpleProduct("I'm a Sheep. Don't mind the dot", 1337);
        Product swordOfDestruction = new FixPriceProduct("Simple knife (unawakened)");
        Product discountedPotatoes = new DiscountedProduct("Potato", 90, 20);

        ProductBasket FixAndDiscountAndSimple = new ProductBasket();

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

        putOutliner();
        putOutliner();
        putOutliner();

        FixAndDiscountAndSimple.addProduct(swordOfDestruction);
        FixAndDiscountAndSimple.addProduct(discountedPotatoes);
        FixAndDiscountAndSimple.addProduct(beepBeep);
        FixAndDiscountAndSimple.printBasket();

    }



    public static void putOutliner() {
        System.out.println("======================================================================================");
    }
}
