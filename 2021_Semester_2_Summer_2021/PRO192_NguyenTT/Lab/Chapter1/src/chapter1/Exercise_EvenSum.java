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
public class Exercise_EvenSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        int i = 1;
        int sum = 0;
        while(i <= n){
            if(i % 2 == 0) sum += i;
            i++;
        }
        System.out.println("Sum of even numbers: " + sum);
    }
}
