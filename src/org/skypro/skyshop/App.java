package org.skypro.skyshop;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        putOutliner();
        putOutliner();
        putOutliner();
        putOutliner();
        putOutliner();
        putOutliner();

        ProductBasket listsTest = new ProductBasket();
        listsTest.addProduct(corn);
        listsTest.addProduct(lamb);
        listsTest.addProduct(strangeProduct);
        listsTest.addProduct(waffles);
        listsTest.addProduct(waffles);
        listsTest.addProduct(waffles);
        listsTest.printBasket();

        List<Product> removed = listsTest.removeProductsByName("Waffle");

        if (removed.isEmpty()) {
            System.out.println("No products were removed.");
        } else {
            for (Product product : removed) {
                System.out.println("  - " + product.toString());
            }
        }
        listsTest.printBasket();
        putOutliner();
        List<Product> removedNonExisting = listsTest.removeProductsByName("bimba");

        if (removedNonExisting.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Product product : removedNonExisting) {
                System.out.println("  - " + product.toString());
            }
        }
        listsTest.printBasket();

        SearchEngine theGreatestSearcher = new SearchEngine(15);
        theGreatestSearcher.add(art1);
        theGreatestSearcher.add(art2);
        theGreatestSearcher.add(art3);
        theGreatestSearcher.add(art4);

        Set<Searchable> searchResults = theGreatestSearcher.search("sheep");
        System.out.println("Search results for 'sheep':");
        if (searchResults.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Searchable result : searchResults) { // Убрано .values()
                System.out.println("  - " + result.getSearchTerm());
            }
        }

        Set<Searchable> searchResult2 = theGreatestSearcher.search("Genshin");
        if (searchResult2.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Searchable result : searchResult2) { // Убрано .values()
                System.out.println("  - " + result.getSearchTerm());
            }
        }
    }

    public static void putOutliner() {
        System.out.println("======================================================================================");
    }
}
