/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7.exception;

/**
 *
 * @author jaydentran1909
 */
public class ExceptionDemo_2 {
    
    public static void main(String args[]) {
        int x = 2, y = 0;
        try{
            System.out.println(x/y);
        }catch(ArithmeticException e){
            System.out.println(e);
            y = 3;
        }finally{
            System.out.println(x/y);
        }
    }
}
