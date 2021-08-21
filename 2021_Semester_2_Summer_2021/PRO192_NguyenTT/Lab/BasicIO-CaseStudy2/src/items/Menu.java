package items;

import java.util.Scanner;

public class Menu {
    private String[] opt;
    private int numOpt = 0;

    public Menu() {
        opt = new String[30];
    }

    public void add(String op) {
        opt[numOpt] = op;
        numOpt++;
    }

    public int getUserChoice() {
        System.out.println("\n\nChoice Menu:\n");
        for (int i = 0; i < numOpt; i++) {
            System.out.printf("%d. %s.\n", i + 1, opt[i]);
        }
        Scanner sc = new Scanner(System.in);
        int choice = getInt.get(0, "Enter your choice: ");
        return choice;
    }
}
