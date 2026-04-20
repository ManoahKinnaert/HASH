package core;

import util.Counter;
/*
* A simple hash table that uses linear probing.
*/
public class HashTableProbed<Key, Value> {
    
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;
    private Counter counter;

    @SuppressWarnings("unchecked")
    public HashTableProbed() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        counter = new Counter();
    }

    @SuppressWarnings("unchecked")
    public HashTableProbed(int cap, Counter counter) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        this.counter = counter;
    }

    // Modular hash
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashTableProbed<Key, Value> t;
        t = new HashTableProbed<>(cap, counter);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {vals[i] = val; return;}
            counter.incrementMisses();
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                counter.incrementHits();
                return vals[i];
            }
            counter.incrementMisses();
        return null;
    }

    public double alpha() {
        return (double) N / M;
    }
}
