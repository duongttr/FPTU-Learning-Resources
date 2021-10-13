import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuTask;
import Utils.FunctionUI;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu(
            new MenuItem("Show information the injection information", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.showInfo();
                }
                
            }),
            new MenuItem("Add new injection", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.addInjection();
                }
                
            }),
            new MenuItem("Update Injection information", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.updateInjection();
                }
                
            }),
            new MenuItem("Delete Injection", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.deleteInjection();
                }
                
            }),

            new MenuItem("Search injection by studentID", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.searchByStudentId();
                }
                
            }),
            new MenuItem("Store data to file", new MenuTask(){

                @Override
                public void task() {
                    FunctionUI.storeToFile();
                }
                
            }),
            new MenuItem("Quit", new MenuTask(){

                @Override
                public void task() {
                    System.exit(0);
                }
                
            })
        );

        while(true){
            
            menu.run();
        }
    }
}
