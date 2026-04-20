package core;

/*
 * A simple hashtable using linear probing.
 */
public class HashTable<Key, Integer> {
	
	private int N;
	private int M;
	private SequentialSearchST<Key, Integer>[] st;
	
	public HashTable() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int M) {
		// Create M linked lists
		this.M = M;
		st = (SequentialSearchST<Key, Integer>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Integer>(null, 0, true);
		}
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int get(Key key) { return (int) st[hash(key)].get(key); }
	
	public void put(Key key, int value) {
	}
	
	@SuppressWarnings("unused")
	private void resize(int cap) {}

	public int getN() {
		return N;
	}
	
	// Return the load factor
	public double getAlpha() {
		return N / M;
	}
}
