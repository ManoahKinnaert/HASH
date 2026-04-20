package core;

public class SequentialSearchST<Key, Integer> {

	Key key;
	int val;
	SequentialSearchST<Key, Integer> next;
	boolean first;
	
	
	public SequentialSearchST(Key key, int val, boolean first) {
		this.key = key;
		this.val = val;
		this.first = first;
	}
	
	
	public int get(Key key) {
		if (this.key != key) {
			return next.get(key);
		}
		return val;
	}
}
