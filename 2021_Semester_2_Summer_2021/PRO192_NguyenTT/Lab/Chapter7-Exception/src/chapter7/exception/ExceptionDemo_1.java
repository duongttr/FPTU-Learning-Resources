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
public class ExceptionDemo_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] a = {1,2,3,4};
        int n =  10;
        try{
            for(int i = 0; i < n; i++){
               System.out.println(a[i]);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
