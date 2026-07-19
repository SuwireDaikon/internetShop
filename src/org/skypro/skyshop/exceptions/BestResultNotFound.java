package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends RuntimeException {
    public BestResultNotFound(String searchRequest) {
        super("Haven't found for " + "'" + searchRequest + "'" + "!");
    }
}
