package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchRequest) {
        super("Haven't found for " + "'" + searchRequest + "'" + "!");
    }
}
