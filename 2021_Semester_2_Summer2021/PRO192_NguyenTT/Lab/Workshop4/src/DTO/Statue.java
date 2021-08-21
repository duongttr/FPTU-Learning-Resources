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
public class Statue extends Item {
    private int weight;
    private String color;

    public Statue() {
    }

    public Statue(int value, String creator, int weight, String color) {
        super(value, creator);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void inputStatue(){
        super.input();
        boolean fail = true;
        while(fail){
            try{
                Scanner sc = new Scanner(System.in);
        
                System.out.print("Weight: ");
                while((this.weight = sc.nextInt()) <= 0){
                    System.out.println("The weight value must be > 0");
                }
        
                sc = new Scanner(System.in);
                System.out.print("Color: ");
                while((this.color = sc.nextLine()).isEmpty()){
                    System.out.println("The color can't be empty!");
                }
                
                fail = false;
               }catch(Exception e){
                     System.out.println("The input is invalid");
               }
        }
        
    }
    
    public void outputStatue(){
        super.output();
        System.out.format("Weight: [%d]\nColor: [%s]\n", this.weight, this.color);
    }
}
