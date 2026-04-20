package core;

public class SequentialSearchST<Key, Value> {

	Key key;
	Value val;
	SequentialSearchST<Key, Value> next;
	boolean first;
	
	
	public SequentialSearchST(Key key, Value val, boolean first) {
		this.key = key;
		this.val = val;
		this.first = first;
	}
	
	
	public Value get(Key key) {
		if (this.key != key) {
			return next.get(key);
		}
		return val;
	}
}
