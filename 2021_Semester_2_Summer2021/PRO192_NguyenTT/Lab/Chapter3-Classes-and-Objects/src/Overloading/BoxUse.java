/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overloading;

/**
 *
 * @author jaydentran1909
 */
public class BoxUse {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Box b = new Box();
        b.output();
        b.setEdge(7,3);
        b.output();
        b.setEdge(10, 10, 10);
        b.output();
    }
}
