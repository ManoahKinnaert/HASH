package util;

import java.util.ArrayList;

public class Counter {
    private int searchHits;
    private int searchMisses;
    private ArrayList<Double> loadFactorsSearch;
    private ArrayList<Double> loadFactorsInsert;

    public Counter() {
        searchHits = 0;
        searchMisses = 0;
    }

    public int getSearchHits() { return searchHits; }

    public int getSearchMisses() { return searchMisses; }

    public double[] getLoadFactorsSearch() { 
        double[] result = new double[loadFactorsSearch.size()];
        for (int i = 0; i < loadFactorsSearch.size(); i++) 
            result[i] = loadFactorsSearch.get(i);
        return result;
    }

    public double[] getLoadFactorsInsert() { 
        double[] result = new double[loadFactorsInsert.size()];
        for (int i = 0; i < loadFactorsInsert.size(); i++) 
            result[i] = loadFactorsInsert.get(i);
        return result;
    }

    public void incrementHits() { searchHits++; }

    public void incrementMisses() { searchMisses++; }

    public void resetHits() { searchHits = 0; }

    public void resetMisses() { searchMisses = 0; }

    public void addLoadFactorSearch(double alpha) { loadFactorsSearch.add(alpha); }

    public void addLoadFactorInsert(double alpha) { loadFactorsInsert.add(alpha); }

    public void reset() {
        resetHits();
        resetMisses();
    }
}
