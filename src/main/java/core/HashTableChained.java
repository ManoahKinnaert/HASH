package core;

/*
 * A simple hashtable using seperate chaining.
 * NOTE: it doesn't support removing a key value pair.
 */
public class HashTableChained<Key, Value> {
	
	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	public HashTableChained() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashTableChained(int M) {
		// Create M linked lists
		this.M = M;
		this.N = 0;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>(null, 0, true);
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