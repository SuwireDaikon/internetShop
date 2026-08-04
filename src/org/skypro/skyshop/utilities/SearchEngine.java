package org.skypro.skyshop.utilities;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchables;


    public SearchEngine(int capacity) { // parameter check
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String request) {
        Set<Searchable> results = new TreeSet<>((s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare == 0) {
                return s1.getName().compareTo(s2.getName());
            }
            return lengthCompare;
        });


        if (request == null || request.isEmpty()) {
            return results;
        }

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
