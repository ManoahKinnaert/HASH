package core;

public class HashTableProbed<Key, Integer> {
    
    private int N;
    private int M = 16;
    private Key[] keys;
    private Integer[] vals;

    @SuppressWarnings("unchecked")
    public HashTableProbed() {
        keys = (Key[]) new Object[M];
        vals = (Integer[]) new Object[M];
    }

    // Modular hash
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int max) {}

    public void put(Key key, Integer val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) 
            if (keys[i].equals(key)) {vals[i] = val; return;}
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Integer get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
}
