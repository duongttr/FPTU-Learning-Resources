package items;

import java.util.Scanner;

public class getInt {
    static int get(int min, String s) {
        Scanner sc = new Scanner(System.in);
        int ans = min - 1;
        while (ans <= min) {
            try {
                System.out.print(s);
                ans = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter valid integer!!!!");
                sc = new Scanner(System.in);
            }
            if (ans <= min) {
                System.out.println("Please enter an integer greater than " + min);
            }
        }
        return ans;
    }
}
