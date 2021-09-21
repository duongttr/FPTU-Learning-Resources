import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuTask;
import Utils.FunctionUI;

// F1: Menu
// F2: Build data structure
// F3: Add a food to the list
// F4: Search a phone by name
// F5: Remove the food by ID
// F6: print the food
// F7: store food to binary file.

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
        }), new MenuItem("Remove the food by ID", new MenuTask() {
            public void task() {

                FunctionUI.removeFood();
            }
        }), new MenuItem("Print food", new MenuTask() {
            public void task() {
                FunctionUI.printFoodWithOption();
            }
        }), new MenuItem("Save to file", new MenuTask() {
            public void task() {
                FunctionUI.saveToFile();
            }
        }), new MenuItem("Load from file", new MenuTask() {
            public void task() {
                FunctionUI.loadFromFile();
            }
        }), new MenuItem("Quit", new MenuTask() {
            public void task() {
                System.exit(0);
            }
        }));

        while (true) {
            FunctionUI.clearScreen();
            menu.run();
        }

    }
}
