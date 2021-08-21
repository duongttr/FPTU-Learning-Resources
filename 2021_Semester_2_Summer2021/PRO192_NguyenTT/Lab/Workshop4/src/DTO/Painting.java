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
public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int value, String creator,int height, int width, boolean isWaterColor, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }
    
    public void inputPainting(){
        super.input();
        boolean fail = true;
        while(fail){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Height: ");
                while((this.height = sc.nextInt()) <= 0){
                    System.out.println("The height value must be > 0");
                }
        
                System.out.print("Width: ");
                while((this.width = sc.nextInt()) <= 0){
                    System.out.println("The width value must be > 0");
                }
                
                
                System.out.print("isWaterColor (true/false): ");
                this.isWaterColor = sc.nextBoolean();

                System.out.print("isFramed (true/false): ");
                this.isFramed = sc.nextBoolean();   
             
                fail = false;
            }catch(Exception e){
                System.out.println("The input is invalid");
            }
        }
    }
    
    public void outputPainting(){
        super.output();
        System.out.format("Height: [%d]\nWidth: [%d]\nisWaterColor: [%b]\nisFramed: [%b]\n", 
                this.height, 
                this.width,
                this.isWaterColor,
                this.isFramed);
    }
}
