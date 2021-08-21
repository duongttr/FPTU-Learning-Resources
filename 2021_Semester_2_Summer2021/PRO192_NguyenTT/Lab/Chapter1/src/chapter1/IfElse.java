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
public class IfElse {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int a = 0;
        int b = 3;
        
        if(a < 10 && b > 5){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        if(a < 10 || b > 5){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        
        if(a++ > 10 && b-- < 5){
            System.out.println("a: " + a + " b: " + b);
        }else{
            System.out.println("a: " + a + " b: " + b);
        }
    }
}
