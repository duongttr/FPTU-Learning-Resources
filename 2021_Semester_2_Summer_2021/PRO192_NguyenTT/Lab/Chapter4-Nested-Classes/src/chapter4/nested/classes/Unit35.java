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
public class Unit35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Unit35 u = new Unit35();
        u.show();
    }
    
    void show(){
        System.out.print("Show of Unit 35");
        System.out.print(""+Tutorial35.a);
        Tutorial35 t = new Tutorial35();
    }
    
}
class Tutorial35{
    private static int a = 2;
    int x;
    int y;
        void show(){
            System.out.println("Show of Tutorial 35");
        }
        Tutorial35(){
            
        }
}


