package util;

import java.io.Console;
import java.util.Scanner;

public class InputUtil {
    public static int getInt(String message) {
		System.out.println(message);
		Scanner in = new Scanner(System.in);
		int result = in.nextInt();
		in.close();
		return result;
	}

    public static String getString(String message) {
        Console console = System.console();
        String s = console.readLine(message);
        return s;
    }
}
