/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

/**
 *
 * @author jaydentran1909
 */
public class Casting_Convert_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        short x, y = 256;
        byte m, n = 6;
        x = n; // systematic conversion
        n = y; // narrow conversion
        n = (byte) y; // explicit casting
        System.out.println(n);
    }
}
