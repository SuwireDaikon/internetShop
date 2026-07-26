package org.skypro.skyshop.utilities;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;

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
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < size; i++) {
            if (searchables[i] != null) {
                String searchTerm = searchables[i].getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();

                int count = countOccurrences(searchTerm, searchLower);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchables[i];
                }
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }
    private int countOccurrences(String text, String search) {
        if (search.isEmpty()) {
            return 0;
        }

        int counter = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            counter++;
            index += search.length();
        }

        return counter;
    }
}
