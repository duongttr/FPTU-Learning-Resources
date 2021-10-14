import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuTask;
import Utils.FunctionUI;

public class App {
    public static void main(String[] args) throws Exception {
        FunctionUI fui = new FunctionUI();


        Menu menu = new Menu(
            new MenuItem("Show information the injection information", new MenuTask(){

                @Override
                public void task() {
                    fui.showInfo();
                }
                
            }),
            new MenuItem("Add new injection", new MenuTask(){

                @Override
                public void task() {
                    fui.addInjection();
                }
                
            }),
            new MenuItem("Update Injection information", new MenuTask(){

                @Override
                public void task() {
                    fui.updateInjection();
                }
                
            }),
            new MenuItem("Delete Injection", new MenuTask(){

                @Override
                public void task() {
                    fui.deleteInjection();
                }
                
            }),

            new MenuItem("Search injection by studentID", new MenuTask(){

                @Override
                public void task() {
                    fui.searchByStudentId();
                }
                
            }),
            new MenuItem("Search injection by vaccineID", new MenuTask(){

                @Override
                public void task() {
                    fui.searchByVaccineId();
                }
                
            }),
            new MenuItem("Store data to file", new MenuTask(){

                @Override
                public void task() {
                    fui.storeToFile();
                }
                
            }),
            new MenuItem("Quit", new MenuTask(){

                @Override
                public void task() {
                    System.exit(0);
                }
                
            })
        );

        fui.loadFromFile();

        while(true){
            menu.run();
        }
    }
}
