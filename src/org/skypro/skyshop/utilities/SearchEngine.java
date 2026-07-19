package org.skypro.skyshop.utilities;
import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Search engine is full! Cannot add more items...");
        }
    }

    public Searchable[] search(String request) {
        if (request == null || request.isEmpty()) {
            return new Searchable[0];
        }

        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < size; i++) {
            if (resultCount >= 5) {
                break;
            }

            if (searchables[i] != null && searchables[i].getSearchTerm().toLowerCase().contains(request.toLowerCase())) {
                results[resultCount] = searchables[i];
                resultCount++;
            }
        }
        return results;
    }
}
