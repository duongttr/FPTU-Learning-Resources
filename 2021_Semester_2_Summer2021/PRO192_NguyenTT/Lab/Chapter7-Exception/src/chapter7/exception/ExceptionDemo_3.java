/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7.exception;


class Demo{
    public int divide1(int x, int y) throws ArithmeticException{
        return x/y;
    }
    public int divide2(int x, int y){
        if(x==0)
            throw new ArithmeticException("Hey. B = 0");
        return x/y;
    }
}

public class ExceptionDemo_3 {

    
    public static void main(String args[]) {
        Demo demo = new Demo();
        System.out.print(demo.divide1(6, 0));
    }
}
