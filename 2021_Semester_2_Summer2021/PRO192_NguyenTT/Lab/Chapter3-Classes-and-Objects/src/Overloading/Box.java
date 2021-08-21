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
public class Box {
    int length;
    int width;
    int depth;

    public Box() {
    }
    
    public Box(int l){
        length = l > 0 ? l : 0;
    }
    
    public Box(int l, int w){
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
    }
    
    public Box(int l, int w, int d){
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
        depth = d > 0 ? d : 0;
    }
    
    public void setEdge(int l, int w){
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
    }
    
    public void setEdge(int l, int w, int d){
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
        depth = d > 0 ? d : 0;
    }
    
    public void output(){
        System.out.format("[%d,%d,%d]\n", length, width, depth);
    }
}
