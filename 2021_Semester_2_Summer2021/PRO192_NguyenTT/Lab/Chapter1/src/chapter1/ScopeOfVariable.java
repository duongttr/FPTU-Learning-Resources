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
public class ScopeOfVariable {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int x = 2, k = 2;
        if(x < 2){
            int y = 3;
            int z = 3;
        }
        y = 6;
        for(int i = 0; i < 3; i++) x += i;
        k += i;
    }
}
