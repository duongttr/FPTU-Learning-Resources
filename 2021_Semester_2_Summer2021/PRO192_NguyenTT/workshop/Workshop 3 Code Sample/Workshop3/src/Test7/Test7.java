/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test7;

/**
 *
 * @author jaydentran1909
 */
public class Test7 {

    static int N = 10;
//    int x = 120;
    static int x = 120;
    static{
        N = 7;
        System.out.print("A");
        x = 500;
    }
    
    public void M(){
        System.out.print(x);
    }
    public static void main(String args[]) {
        Test7 obj = new Test7();
        obj.M();
    }
}
