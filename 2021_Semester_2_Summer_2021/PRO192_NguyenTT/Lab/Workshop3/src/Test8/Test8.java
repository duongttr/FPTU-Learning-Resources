/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test8;

/**
 *
 * @author jaydentran1909
 */
public class Test8 {

    static int N = 10;
    int x = 120;
    static int y;
    static{
        N = 7;
        //int y = 7;
        y = 7;
        System.out.print("A" + (N+y));
    }
    
    public void M(){
        System.out.print(x + y);
    }
    public static void main(String args[]) {
        Test8 obj = new Test8();
        obj.M();
    }
}
