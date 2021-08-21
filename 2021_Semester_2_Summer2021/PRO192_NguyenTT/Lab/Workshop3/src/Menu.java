
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class Menu {
    private String[] nameOpt;
    private int count = 0;
    
    public Menu(int noOpt){
        nameOpt = new String[noOpt];
    }
    
    public void add(String name){
        if(count < nameOpt.length){
            nameOpt[count++] = name;
        }else{
            System.out.println("You reach limit of menu!");
        }
    }
    
    public int getChoice(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        System.out.println("\n-MENU-");
        for(int i = 0; i < this.nameOpt.length; i++){
            System.out.println(nameOpt[i]);
        }
        System.out.print("Input your choice: ");
        choice = sc.nextInt();
        return choice;
    }
}
