package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class testCounter {
    
    Counter counter;

    @BeforeEach
    void init() {
        counter = new Counter();
    }
    
    @Test 
    void testConstructorZeroSearchHits() {
        assertEquals(0, counter.getSearchHits());
    }

    @Test 
    void testConstructorZeroSearchMisses() {
        assertEquals(0, counter.getSearchMisses());
    }

    @Test 
    void testIncrementHits() {
        counter.incrementHits();
        assertEquals(1, counter.getSearchHits());
    }

    @Test 
    void testIncrementNHits() {
        int n = 5;
        for (int i = 0; i < n; i++)
            counter.incrementHits();
        assertEquals(n, counter.getSearchHits());
    }

    @Test 
    void testIncrementMisses() {
        counter.incrementMisses();
        assertEquals(1, counter.getSearchMisses());
    }

    @Test 
    void testIncrementNMisses() {
        int n = 5;
        for (int i = 0; i < n; i++)
            counter.incrementMisses();
        assertEquals(n, counter.getSearchMisses());
    }
}
