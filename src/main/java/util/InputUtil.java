package util;

import java.io.Console;
import java.util.Scanner;

public class InputUtil {

    public static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
		System.out.println(message);
		int result = scanner.nextInt();
		return result;
	}

    public static String getString(String message) {
        Console console = System.console();
        String s = console.readLine(message);
        return s;
    }
}
