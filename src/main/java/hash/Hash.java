package hash;

import java.util.Scanner;

public class Hash {
	
	public int getInt(String message) {
		System.out.println(message);
		Scanner in = new Scanner(System.in);
		int result = in.nextInt();
		in.close();
		return result;
	}
	
	public static void main(String[] args) {
		Hash hash = new Hash();
		int expNum = hash.getInt("Experiment number: ");
		if (expNum == 1) {
			System.out.println("Test");
		} else if (expNum == 2) {
			System.out.println("Test2");
		} else {
			System.out.println("Invalid experiment number!");
		}
	}
}
