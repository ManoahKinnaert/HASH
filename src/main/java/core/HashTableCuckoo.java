package core;

/*
A simple hash table that attempts to use Cuckoo hashing.
See: https://en.wikipedia.org/wiki/Cuckoo_hashing
*/
public class HashTableCuckoo<Key, Value> {
    private int N;

    public HashTableCuckoo() {
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value val) {
    }

    public Value get(Key key) {
		return null;
    }    
}
