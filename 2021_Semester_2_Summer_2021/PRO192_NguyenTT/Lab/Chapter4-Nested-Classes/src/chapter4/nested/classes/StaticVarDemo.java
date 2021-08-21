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
public class StaticVarDemo {
    static int N = 10;
    int x, y;
    
    public StaticVarDemo(int xx, int yy){
        x = xx;
        y = yy;
    }
    
    public void setN(int n){
        N = n;
    }
    
    public void output(){
        System.out.println(N + ", " + x + ", " + y);
    }
}
