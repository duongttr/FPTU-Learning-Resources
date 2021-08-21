/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test6;

/**
 *
 * @author jaydentran1909
 */
public class Test6 {

    static int N = 10;
    int x = 120;
    static{
        N = 50;
        System.out.print("A");
    }
    
    public void M(){
        System.out.print(x);
    }
    public static void main(String args[]) {
        Test6 obj = new Test6();
        obj.M();
    }
}
