package Menu;

import java.util.Vector;
import java.util.function.Predicate;
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
        //FunctionUI.printREADME("menu.txt");
        //System.out.println("Current opened file: " + TextColor.create(FunctionUI.openedFilePath, Color.PURPLE) + (FunctionUI.needSaveState ? TextColor.create(" (unsaved) ", Color.YELLOW) : ""));
        for (int i = 0; i < this.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, this.get(i).getName()));
        }

        int choice = Inputter.getIntWithCondition(String.format("Type your choice [1..%d]: ", this.size()), true,
                        new Predicate<Integer>(){

                            @Override
                            public boolean test(Integer t) {
                                return t > 0 && t <= size();
                            }
                            
                        });
        this.get(choice - 1).getTask().task();
    }

}
