package util;

import java.util.Scanner;

public class InputUtil {
    public static int getInt(String message) {
		System.out.println(message);
		Scanner in = new Scanner(System.in);
		int result = in.nextInt();
		in.close();
		return result;
	}
}
