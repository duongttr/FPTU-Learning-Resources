import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuTask;
import Utils.FunctionUI;

/*
    Created by Tran Thanh Duong (SE160185)
*/

public class App {

    public static void main(String[] args) throws Exception {

        // clear at startup

        Menu menu = new Menu(new MenuItem("Add a new food", new MenuTask() {
            @Override
            public void task() {
                FunctionUI.addFood();
            }
        }), new MenuItem("Search a food by name", new MenuTask() {
            @Override
            public void task() {
                FunctionUI.searchFoodByName();
            }
        }),
        // new MenuItem("Search a food by weight", new MenuTask() {
        //     @Override
        //     public void task() {
        //         FunctionUI.searchFoodByWeight();
        //     }
        // }),
        new MenuItem("Remove the food by ID", new MenuTask() {
            public void task() {

                FunctionUI.removeFood();
            }
        }), new MenuItem("Print food", new MenuTask() {
            public void task() {
                FunctionUI.printFoodWithOption();
            }
        }), new MenuItem("Open file", new MenuTask() {
            public void task() {
                FunctionUI.openFile();
            }
        }), new MenuItem("Save file", new MenuTask() {
            public void task() {
                FunctionUI.saveToFile();
            }
        }), new MenuItem("Quit", new MenuTask() {
            public void task() {
                FunctionUI.quitProgram();
            }
        }));

        while (true) {
            FunctionUI.clearScreen();
            menu.run();
        }

    }
}
