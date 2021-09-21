package Utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class Inputter {

    private static String errorString = "There's an error, please try again!";

    private static Scanner sc = new Scanner(System.in);

    public static boolean askYN(String message) {
        do {
            System.out.print(message);
            String choice = sc.nextLine();
            if (choice.toUpperCase().equals("Y")) {
                return true;
            } else if (choice.toUpperCase().equals("N")) {
                return false;
            }
        } while (true);

    }

    public static Integer getInt(String message, boolean repeatedIfError) {
        do {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (Exception ex) {
                System.out.println(errorString);
            }
        } while (repeatedIfError);
        return null;
    }

    public static Double getDoubleWithCondition(String message, boolean repeatedIfError, Predicate<Double> condition) {
        do {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());
                if (condition.test(value)) {
                    return value;
                }
            } catch (Exception ex) {
                System.out.println(errorString);
            }
        } while (repeatedIfError);
        return null;
    }

    public static Integer getIntWithCondition(String message, boolean repeatedIfError, Predicate<Integer> condition) {
        do {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (condition.test(value)) {
                    return value;
                }
            } catch (Exception ex) {
                System.out.println(errorString);
            }
        } while (repeatedIfError);
        return null;
    }

    public static String getString(String message, boolean repeatedIfError, boolean notBlankStr) {
        do {
            System.out.print(message);
            String value = sc.nextLine();
            if (notBlankStr) {
                if (!value.isBlank()) {
                    return value;
                } else {
                    System.out.println("String can't be blank!");
                }
            } else {
                return value;
            }
        } while (repeatedIfError);
        return null;
    }

    public static String getStringWithPattern(String message, boolean repeatedIfError, String pattern) {
        do {
            System.out.print(message);
            String value = sc.nextLine();
            if (value.matches(pattern)) {
                return value;
            } else {
                System.out.println("String doesn't match pattern");
            }
        } while (repeatedIfError);
        return null;
    }
}
