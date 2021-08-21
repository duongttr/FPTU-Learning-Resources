/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class InputOutData {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] a;
        int n;
        int i;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        a = new int[n];
        for(i = 0; i < n;i++){
            System.out.print("Enter data for element " + (i+1) + "/" + n+": ");
            a[i] = Integer.parseInt(sc.nextLine());
        }
        
        System.out.print("Entered value: ");
        for(i = 0; i < n; i++){
            System.out.format("%5d", a[i]);
        }
        int s = 0;
        for(int x: a) s += x;
        System.out.println("\nSum of values: " + s);
    }
}
