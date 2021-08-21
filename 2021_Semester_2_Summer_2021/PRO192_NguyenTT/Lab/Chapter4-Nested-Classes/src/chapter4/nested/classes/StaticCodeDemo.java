/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4.nested.classes;

/**
 *
 * @author jaydentran1909
 */
public class StaticCodeDemo {
    public static int N = 10;
    int x = 5, y = 7;
    
    static{
        System.out.println("Static code: " + N);
    }
    
    int sum(){
        return x+y;
    }
    static {
        System.out.println("Static: Hello");
    }
}
