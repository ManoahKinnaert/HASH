package util;

public class Counter {
    private int searchHits;
    private int searchMisses;

    public Counter() {
        searchHits = 0;
        searchMisses = 0;
    }

    public int getSearchHits() { return searchHits; }

    public int getSearchMisses() { return searchMisses; }

    public void incrementHits() { searchHits++; }

    public void incrementMisses() { searchMisses++; }

    public void resetHits() { searchHits = 0; }

    public void resetMisses() { searchMisses = 0; }

    public void reset() {
        resetHits();
        resetMisses();
    }
}
