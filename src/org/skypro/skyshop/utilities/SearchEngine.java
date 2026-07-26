package org.skypro.skyshop.utilities;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;


    public SearchEngine(int capacity) { // parameter check
        this.searchables = new LinkedList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String request) {
        if (request == null || request.isEmpty()) {
            return new LinkedList<>();
        }

        List<Searchable> results = new LinkedList<>();
        String requestLower = request.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(requestLower)) {
                results.add(item);
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
        String searchLower = search.toLowerCase();

        for (Searchable item : searchables) {
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();
                int count = countOccurrences(searchTerm, searchLower);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
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
