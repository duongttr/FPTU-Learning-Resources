/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author jaydentran1909
 */
public class Menu extends Vector<String> {
    public int getChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }

        do {
            try {
                System.out.print("---->Your choice: ");
                Scanner sc = new Scanner(System.in);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception ex) {
                System.out.println("Your choice is invalid!");
            }
        } while (true);
    }
}
