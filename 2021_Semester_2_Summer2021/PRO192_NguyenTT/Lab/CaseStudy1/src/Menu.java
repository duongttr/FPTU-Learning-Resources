/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class Menu {
    String[] hints;
    int n = 0;
    
    public Menu(int size){
        if(size < 1) size = 10;
        hints = new String[size];
    }
    
    public void add(String aHint){
        if(n < hints.length){
            hints[n++] = aHint;
        }
    }
    
    public int getChoice(){
        int result = 0;
        if(n > 0){
            for(int i = 0; i < n; i++){
                System.out.format("%d - %s\n", i+1, hints[i]);
            }
            System.out.print("Please select an operation: ");
            Scanner sc = new Scanner(System.in);
            result = sc.nextInt();
        }
        return result;
    }
}
