package GUI;

import DTO.EmployeeList;
import DTO.Utils;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.addMenuItem("1. Add a new employee");
        menu.addMenuItem("2. Remove an employee");
        menu.addMenuItem("3. Promoting the employee's salary");
        menu.addMenuItem("4. Sorting list by [CODE]");
        menu.addMenuItem("5. Print out the list");
        menu.addMenuItem("6. Save to files");
        menu.addMenuItem("7. Quit");

        String fileName = "data.txt";
        EmployeeList list = new EmployeeList();
        list.loadDataFromFile(fileName);
        int choiceUser;
        do {
            Utils.clear();
            choiceUser = menu.getUserChoice();
            switch (choiceUser) {
                case 1:
                    list.addEmployee();
                    break;
                case 2:
                    list.removeEmployee();
                    break;
                case 3:
                    list.promoteSalary();
                    break;
                case 4:
                    list.sortList();
                    break;
                case 5:
                    list.listEmployee();
                    break;
                case 6:
                    list.save(fileName);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }

        } while (choiceUser != 7);

    }
}
