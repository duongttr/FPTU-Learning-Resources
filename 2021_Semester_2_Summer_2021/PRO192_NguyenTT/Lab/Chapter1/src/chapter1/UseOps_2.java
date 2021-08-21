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
public class UseOps_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] a = {4, 4};
        int b =0;
        int c = 1;
        a[b] = b = c;
        System.out.println("a: " + a[0] + ","+ a[1]);
    }
}
