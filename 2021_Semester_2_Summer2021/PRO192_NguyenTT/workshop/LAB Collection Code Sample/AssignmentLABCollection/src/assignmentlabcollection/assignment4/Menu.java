package assignmentlabcollection.assignment4;

import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {

    public Menu() {
    }

    public void addItem(String... items) {
        for(String s: items){
            this.add(s);
        }
    }

    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("-MENU ASSIGNMENT 4-");
            System.out.println("-------------------");
            for (int i = 0; i < this.size(); i++) {
                System.out.println(i+1 + ". " + this.get(i));
            }
            System.out.print("==>Your choice: ");
            try{
                choice = sc.nextInt();
                if(choice >= 1 && choice <= this.size()){
                    break;
                }
            }catch(Exception ex){
                System.out.println("The input value is invalid!");
            }
        }
        return choice;
    }
}
