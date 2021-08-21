package javaapplication25;

import java.util.Vector;
import java.util.function.Predicate;

public class Menu extends Vector<String> {
    public Menu() {
    }

    public int getUserChoice(){
        System.out.println("-MENU-");
        for(int i = 0; i < this.size();i++){
            System.out.println((i+1)+ ". " + this.get(i));
        }
        int sizeList = this.size();
        int choice = Inputter.getIntWithCondition("--->Your choice: ", true, new Predicate<Integer>(){

            @Override
            public boolean test(Integer t) {
                return t >= 1 && t <= sizeList;
            }
            
        });
        return choice;
    }
}
