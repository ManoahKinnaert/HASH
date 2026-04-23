package core;

/*
* A simple hash table that uses linear probing.
*/
public class HashTableProbed<Key, Value> {
    
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    @SuppressWarnings("unchecked")
    public HashTableProbed() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    @SuppressWarnings("unchecked")
    public HashTableProbed(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    // Modular hash
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashTableProbed<Key, Value> t;
        t = new HashTableProbed<>(cap);
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
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public double alpha() {
        return (double) N / M;
    }

    public int getProbesForSearch(Key key) {
        int probes = 1;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) { return probes; }
            probes++;
        }
        return probes;
    }

    public int size() { return N; }
}
