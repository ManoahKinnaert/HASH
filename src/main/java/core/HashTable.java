package core;

/*
 * A simple hashtable using linear probing.
 */
public class HashTable<Key, Value> {
	
	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	public HashTable() {
		this(997);
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int M) {
		// Create M linked lists
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>(null, null, true);
		}
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key) { return (Value) st[hash(key)].get(key); }
	
	public void put(Key key, Value value) {
	}
	
	@SuppressWarnings("unused")
	private void resize(int cap) {}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
}
