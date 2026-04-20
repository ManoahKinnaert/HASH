package core;

/*
 * A simple hashtable using linear probing.
 * NOTE: it doesn't support removing a key value pair (yet).
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
		this.N = 0;
		st = (SequentialSearchST<Key, Integer>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Integer>(null, 0, true);
		}
	}
	
	// Modular hash
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int get(Key key) { return (int) st[hash(key)].get(key); }
	
	public void put(Key key, int val) {
		st[hash(key)].put(key, val);
		N++;
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