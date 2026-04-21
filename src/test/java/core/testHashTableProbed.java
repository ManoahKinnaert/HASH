package core;

/*
This is not a unit test. Just a quick test to see if HashTableProbed works...
*/
public class testHashTableProbed {
    public static void main(String[] args) {
        HashTableProbed<String, Integer> table = new HashTableProbed<String, Integer>();
		table.put("Apple", 15);
		System.out.println("Hits " + table.getHits());
		System.out.println("Misses: " + table.getMisses());
		table.put("Banana", 2);
		System.out.println("Hits " + table.getHits());
		System.out.println("Misses: " + table.getMisses());
		table.put("Apple", 12);
		System.out.println("Hits " + table.getHits());
		System.out.println("Misses: " + table.getMisses());
		table.get("Apple");
		System.out.println("Hits " + table.getHits());
		System.out.println("Misses: " + table.getMisses());
    }
}
