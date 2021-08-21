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
public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
    } 

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void inputVase(){
        super.input();
        boolean fail = true;
        while(fail){
            try{
                Scanner sc = new Scanner(System.in);
        
                System.out.print("Height: ");
                while((this.height = sc.nextInt()) <= 0){
                    System.out.println("The height value must be > 0");
                }
        
                sc = new Scanner(System.in);
                System.out.print("Material: ");
                while((this.material = sc.nextLine()).isEmpty()){
                    System.out.println("The material can't be empty!");
                }
                fail = false;
            }catch(Exception e){
                System.out.println("The input is invalid");
            }
        }
        
    }
    
    public void outputVase(){
        super.output();
        System.out.format("Height: [%d]\nMaterial: [%s]\n", this.height, this.material);
    }
}
