package core;

/*
This is not a unit test. Just a quick test to see if HashTableProbed works...
*/
public class testHashTableProbed {
    public static void main(String[] args) {
        HashTableProbed<String, Integer> table = new HashTableProbed<String, Integer>();
		table.put("Apple", 15);
		table.put("Banana", 2);
		//table.put("Apple", 12);

		System.out.println(table.get("Apple"));
    }
}
