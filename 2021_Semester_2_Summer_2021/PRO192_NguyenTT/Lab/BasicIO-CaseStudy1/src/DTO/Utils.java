package DTO;

import java.io.IOException;
import java.util.Scanner;

public class Utils {

    /* Clear entire screen */
    public static void clear() {
        System.out.print(printChar('\n', 100));
    }

    /* Print a character with multiple times */
    public static String printChar(char c, int n) {
        String ret = "";
        for (int i = 0; i < n; i++) {
            ret += c;
        }
        return ret;
    }

    public static void showTextAndRetype(String text) {
        System.out.println(text);
    }

    /* Check if user wants to continue current process */
    public static boolean wantToContinue() {

        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.print("Do you want to continue? (y/n): ");
                char choice = sc.nextLine().toLowerCase().charAt(0);
                if (choice == 'y') {
                    return true;
                } else if (choice == 'n') {
                    return false;
                }
            } while (true);

        } catch (Exception e) {

            // nothing here
        }

        return false;
    }

    /* Pause screen for watching printed text */
    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
