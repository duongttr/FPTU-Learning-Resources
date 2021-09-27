import Menu.Menu;
import Menu.MenuItem;
import Menu.MenuTask;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu(
            new MenuItem("Add student's vaccine injection information", new MenuTask(){

                @Override
                public void task() {
                    
                }
                
            }),
            new MenuItem("Add student's vaccine injection information", new MenuTask(){

                @Override
                public void task() {
                    
                }
                
            }),
            new MenuItem("Updating information of students' vaccine injection", new MenuTask(){

                @Override
                public void task() {
                    
                }
                
            }),
            new MenuItem("Updating information of students' vaccine injection", new MenuTask(){

                @Override
                public void task() {
                    
                }
                
            }),

            new MenuItem("Updating information of students' vaccine injection", new MenuTask(){

                @Override
                public void task() {
                    
                }
                
            }),
        );

        while(true){
            menu.run();
        }
    }
}
