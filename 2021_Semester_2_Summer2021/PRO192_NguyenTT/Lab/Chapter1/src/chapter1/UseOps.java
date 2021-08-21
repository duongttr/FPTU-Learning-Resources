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
public class UseOps {
    public static void main(String[] args){
        int x = -1;
        System.out.println("-1<<1: " + (x << 1));
        System.out.println("-1>>1: " + (x >> 1));
        System.out.println("-1>>>1: " + (1 >>> 1));
        System.out.println("3|4: " + (3 | 4));
        System.out.println("3&4: " + (3 & 4));
        System.out.println("3^4: " + (3 ^ 4));
        String s = "Hello";
        boolean result = s instanceof String;
        System.out.println("Hello is an instance of string: " + result);
    }
}
