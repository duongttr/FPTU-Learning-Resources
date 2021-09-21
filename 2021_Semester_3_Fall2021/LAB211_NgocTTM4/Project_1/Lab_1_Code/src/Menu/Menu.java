package Menu;

import java.util.Vector;

import Utils.FunctionUI;
import Utils.Inputter;

public class Menu extends Vector<MenuItem> {
    // constructor menu
    public Menu(MenuItem... menus) {
        for (int i = 0; i < menus.length; i++) {
            this.add(menus[i]);
        }
    }

    // add new item
    public void run() {
        FunctionUI.printREADME("menu.txt");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, this.get(i).getName()));
        }

        int choice = Inputter.getInt(String.format("Type your choice [1..%d]: ", this.size()), true);
        this.get(choice - 1).getTask().task();
    }

}
