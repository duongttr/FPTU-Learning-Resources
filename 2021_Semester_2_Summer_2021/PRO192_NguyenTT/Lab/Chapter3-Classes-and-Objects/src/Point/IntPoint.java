/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Point;

/**
 *
 * @author jaydentran1909
 */
public class IntPoint {
    private int x;
    private int y;

    public IntPoint() {
    }
    
    

    public IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void output(){
        System.out.format("[%d, %d]", x, y);
    }
}
