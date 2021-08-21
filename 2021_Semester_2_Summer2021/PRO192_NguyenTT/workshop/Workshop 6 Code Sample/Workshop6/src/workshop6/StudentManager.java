/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6;

/**
 *
 * @author jaydentran1909
 */
public class StudentManager {
    public static void main(String[] args) {
        int choice = 0;
        StudentList list = new StudentList();
        Menu menu = new Menu();
        menu.add("Add new student");
        menu.add("Search a student");
        menu.add("Update a student");
        menu.add("Remove a student");
        menu.add("Sort by code");
        menu.add("Sort by name");
        menu.add("Sort by mark");
        menu.add("List all student");
        menu.add("Quit");
        do {
            System.out.println("\n\nStudent Manager");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.addStudent();
                    break;
                case 2:
                    list.searchStudent();
                    break;
                case 3:
                    list.updateStudent();
                    break;
                case 4:
                    list.removeStudent();
                    break;
                case 8:
                    list.printAll();
                    break;
                case 5:
                    list.sortStudent(1);
                    break;
                case 6:
                    list.sortStudent(2);
                    break;
                case 7:
                    list.sortStudent(3);
                    break;
            }
        } while (choice != menu.size());
    }
}
