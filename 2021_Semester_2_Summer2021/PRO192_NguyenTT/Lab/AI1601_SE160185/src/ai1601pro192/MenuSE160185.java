package ai1601pro192;

import java.util.Vector;
import java.util.function.Predicate;

public class MenuSE160185 extends Vector<String> {
    public MenuSE160185() {
    }

    public int getUserChoice(){
        System.out.println("\n\n");
        System.out.println("-MENU-");
        for(int i = 0; i < this.size();i++){
            System.out.println((i+1)+ ". " + this.get(i));
        }
        int sizeList = this.size();
        int choice = InputterSE160185.getIntWithCondition("--->Your choice: ", true, new Predicate<Integer>(){

            @Override
            public boolean test(Integer t) {
                return t >= 1 && t <= sizeList;
            }
            
        });
        return choice;
    }
}
