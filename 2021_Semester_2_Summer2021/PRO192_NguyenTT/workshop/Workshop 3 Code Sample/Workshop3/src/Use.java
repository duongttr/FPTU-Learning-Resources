/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class Use {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Menu menu = new Menu(9);
        menu.add("1. Test 1");
        menu.add("2. Test 2");
        menu.add("3. Test 3");
        menu.add("4. Test 4");
        menu.add("5. Test 5");
        menu.add("6. Test 6");
        menu.add("7. Test 7");
        menu.add("8. Test 8");
        menu.add("9. Exit");
        
        boolean continueLoop = true;
        while(continueLoop){
           switch(menu.getChoice()){
            case 1:
                Test1.Test1.main(null);
                break;
            case 2:
                Test2.Test2.main(null);
                break;
            case 3:
                Test3.Test3.main(null);
                break;
            case 4:
                Test4.Test4.main(null);
                break;
            case 5:
                Test5.Test5.main(null);
                break;
            case 6:
                Test6.Test6.main(null);
                break;
            case 7:
                Test7.Test7.main(null);
                break;
            case 8:
                Test8.Test8.main(null);
                break;
            case 9:
                continueLoop = false;
                break;
        }
        }
        
    }
}
