package hash;

import experiments.*;
import util.InputUtil;

public class Hash {
	
	public static void main(String[] args) {
		int expNum = InputUtil.getInt("Experiment number: ");
		if (expNum == 1) {
			new Hash1().run();
		} else if (expNum == 2) {
			new Hash2().run();
		} else {
			System.out.println("Invalid experiment number!");
		}
	}
}
