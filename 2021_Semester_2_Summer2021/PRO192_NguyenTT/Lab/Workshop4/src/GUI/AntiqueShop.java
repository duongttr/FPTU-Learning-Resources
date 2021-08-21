/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.*;
import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class AntiqueShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Item item = null;
        int choice;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("\n1. Create a Vase");
            System.out.println("2. Create a Statue");
            System.out.println("3. Create a Painting");
            System.out.println("4. Display the Item");
            System.out.println("Other. Exit");
            System.out.print("Input your choice: ");
       
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    item = new Vase();
                    ((Vase)item).inputVase();
                    break;
                case 2:
                    item = new Statue();
                    ((Statue)item).inputStatue();
                    break;
                case 3:
                    item = new Painting();
                    ((Painting)item).inputPainting();
                    break;
                case 4:
                    if(item != null){
                       if(item instanceof Vase){
                           ((Vase)item).outputVase();
                       }else if(item instanceof Statue){
                           ((Statue)item).outputStatue();
                       }else if(item instanceof Painting){
                           ((Painting)item).outputPainting();
                       }
                    }else System.out.println("You need to create an object!");
                    break;

            }
        }while(choice <= 4);
    }
}
