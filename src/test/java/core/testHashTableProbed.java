package core;

/*
This is not a unit test. Just a quick test to see if HashTableProbed works...
*/
public class testHashTableProbed {
    public static void main(String[] args) {
        HashTableProbed<String, Integer> table = new HashTableProbed<String, Integer>();
		table.put("Aa", 1);
		table.put("BB", 2);
		System.out.println(table.get("Aa"));
		System.out.println(table.get("BB"));
    }
}
