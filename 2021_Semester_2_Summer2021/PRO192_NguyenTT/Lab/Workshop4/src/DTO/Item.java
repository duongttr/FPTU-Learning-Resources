/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class Item {
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public void input(){
        
        boolean fail = true;
        while(fail){
            try{
                Scanner sc = new Scanner(System.in);
        
                System.out.print("Value: ");
                while((this.value = sc.nextInt()) <= 0){
                    System.out.println("The value number must be > 0");
                }
        
                sc = new Scanner(System.in);
                System.out.print("Creator: ");
                while((this.creator = sc.nextLine()).isEmpty()){
                    System.out.println("The creator can't be empty!");
                }
                fail = false;
            }catch(Exception e){
                System.out.println("The input is invalid");
            }
        }
        
    }
    
    public void output(){
        System.out.format("Value: [%d]\nCreator: [%s]\n", this.value, this.creator);
    }
}
