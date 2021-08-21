/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.util.Arrays;

/**
 *
 * @author jaydentran1909
 */
public class GenericArray<T> {
    public static <T> T get(int i, T[] ar){
        return ar[i];
    }
    
    public static<T> void output(T[] ar){
        for(T x: ar){
            System.out.print(x + ",");
            
        }
        System.out.println();
    }
    
    public static<T> void sort(T[] ar ){
        Arrays.sort(ar);
    }
}
