package org.skypro.skyshop;

import java.util.Arrays;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.utilities.SearchEngine;

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
        Product strangeProduct = new SimpleProduct("minus", 8);

        Article art1 = new Article( "SR lyrics", "頬を刺す朝の山手通り|煙草の空き箱を捨てる|今日もまた足の踏み場は無い|小部屋が孤独を甘やかす");
        Article art2 = new Article("Ludonarrative Dissonance in Bioshock (Clint Hocking)", "...Bioshock seems to suffer from a powerful dissonance between what it is about as a game, and what it is about as a story...");
        Article art3 = new Article("Сандроне в Genshin Impact", "...По механике усиленной атаки и стилю в сражении она схожа с судьёй Нёвиллетом и является первым героем, играющим от новых Звёздных реакций, которые станут метой в Снежной...");
        Article art4 = new Article("minus eight", "i am sheep");

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

        putOutliner();
        putOutliner();
        putOutliner();

        SearchEngine searcher = new SearchEngine(100);

        searcher.add(corn);
        searcher.add(waffles);
        searcher.add(lamb);
        searcher.add(beepBeep);
        searcher.add(swordOfDestruction);
        searcher.add(discountedPotatoes);
        searcher.add(strangeProduct);

        searcher.add(art1);
        searcher.add(art3);
        searcher.add(art2);
        searcher.add(art4);

        Searchable[] t1 = searcher.search("meow");
        Searchable[] t2 = searcher.search("game");
        Searchable[] t3 = searcher.search("sheep");
        Searchable[] t4 = searcher.search("minus");

        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
        System.out.println(Arrays.toString(t3));
        System.out.println(Arrays.toString(t4));

        putOutliner();
        putOutliner();
        putOutliner();

        try {
            Product illProduct0 = new SimpleProduct("", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Product illProduct01 = new SimpleProduct(null, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Product illProduct10 = new SimpleProduct("     ", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Product illProduct11 = new SimpleProduct("meow", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Product illProduct100 = new DiscountedProduct("mreow", 5, -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Product illProduct101 = new DiscountedProduct("mreowoww", -995, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }

        putOutliner();

        SearchEngine exceptionTrierAndFryer = new SearchEngine(15);
        exceptionTrierAndFryer.add(art1);
        exceptionTrierAndFryer.add(art2);
        exceptionTrierAndFryer.add(art3);
        exceptionTrierAndFryer.add(art4);

        try {
            Searchable bestMatch = exceptionTrierAndFryer.findBestMatch("www");
            System.out.println("Best result found: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Error! " + e.getMessage());
        }
        try {
            Searchable bestMatch = exceptionTrierAndFryer.findBestMatch("Bioshock");
            System.out.println("Best result found: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Error! " + e.getMessage());
        }

    }



    public static void putOutliner() {
        System.out.println("======================================================================================");
    }
}
