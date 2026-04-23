package hash;

import java.util.Scanner;
import experiments.*;

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
			new Hash1().run();
		} else if (expNum == 2) {
			new Hash2().run();
		} else {
			System.out.println("Invalid experiment number!");
		}
	}
}
