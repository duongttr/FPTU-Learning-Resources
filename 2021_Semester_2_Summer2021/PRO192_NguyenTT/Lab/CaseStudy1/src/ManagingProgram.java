/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jaydentran1909
 */
public class ManagingProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Menu menu = new Menu(5);
        menu.add("Add new person");
        menu.add("Remove a person");
        menu.add("Update a person");
        menu.add("List");
        menu.add("Quit");
        
        int choice;
        PersonList list = new PersonList(50);
        do{
            System.out.println("\nPERSON MANAGER");
            choice = menu.getChoice();
            switch(choice){
                case 1: list.add(); break;
                case 2: list.remove(); break;
                case 3: list.update(); break;
                case 4: list.sort(); list.print(); break;
            }
        }while(choice != 5);
    }
}
