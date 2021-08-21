package employees;

import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String>{
    public Menu(){
        super();
    }

    public void addMenuItem(String s){
        add(s);
    }

    public int getUserChoice(){
        Scanner sc = new Scanner(System.in);
        drawingMenu();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        Utils.clear();
        return choice;
    }

    private void drawingMenu() {
        int maxLength = -1;

        // Get maximum's length of strings
        for(String itemName: this){
            if(itemName.length() >  maxLength){
                maxLength = itemName.length();
            }
        }

        // Alogorithm for drawing menu
        int padding = 3;
        if(maxLength % 2 != 0) maxLength += 1;
        System.out.println("╔" + Utils.printChar('═', (maxLength-4)/2+ padding)+ "MENU" 
                            + Utils.printChar('═', (maxLength-4)/2 + padding) + "╗");
        for(int i = 0; i < padding-1;i++){
            System.out.println("║" + Utils.printChar(' ', maxLength + padding * 2) + "║");
        }
        for(String itemName: this){
            System.out.println("║" + Utils.printChar(' ', padding)  + itemName + 
            Utils.printChar(' ', maxLength - itemName.length()) 
            + Utils.printChar(' ', padding)
            +"║");
        }
        for(int i = 0; i < padding-1;i++){
            System.out.println("║" + Utils.printChar(' ', maxLength + padding * 2) + "║");
        }
        System.out.println("╚" + Utils.printChar('═', maxLength + padding * 2) + "╝");
    }
    
    
}
