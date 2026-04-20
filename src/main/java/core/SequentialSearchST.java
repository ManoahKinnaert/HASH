package core;

/*
 * A simple linked list implementation
 */
public class SequentialSearchST<Key, Value> {

	Key key;
	int val;
	SequentialSearchST<Key, Value> next;
	boolean first;
	
	
	public SequentialSearchST(Key key, int val, boolean first) {
		this.key = key;
		this.val = val;
		this.first = first;
		this.next = null;
	}
	
	
	public int get(Key key) {
		if (this.key != key) {
			return next.get(key);
		}
		return val;
	}
	
	public void put(Key key, int val) {
		SequentialSearchST<Key, Value> current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new SequentialSearchST<Key, Value>(key, val, false);
	}
}
