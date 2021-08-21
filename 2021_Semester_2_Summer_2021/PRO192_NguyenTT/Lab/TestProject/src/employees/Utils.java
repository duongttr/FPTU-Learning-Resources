package employees;

import java.io.IOException;
import java.util.Scanner;

public class Utils {

    /* Clear entire screen */
    public static void clear(){
        System.out.print("\033\143");
    }

    /* Print a character with multiple times */
    public static String printChar(char c, int n){
        String ret = "";
        for(int i = 0; i < n;i++){
            ret += c;
        }
        return ret;
    }

    /* Use for clear current line and move cursor to the last of previous line */
    public static void eraseLine(int n){
        System.out.print(String.format("\033[%dA", n));
        System.out.print("\033[2K");
    }

    public static void showTextAndRetype(String text){
        Utils.eraseLine(1);
        System.out.print(text);
        pause();
        Utils.eraseLine(1);
    }

    /* Check if user wants to continue current process */
    public static boolean wantToContinue(){
        
        Scanner sc = new Scanner(System.in);
        try{
            do{
                System.out.print("Do you want to continue? (y/n): ");
                char choice = sc.nextLine().toLowerCase().charAt(0);
                if(choice == 'y'){
                    return true;
                }else if(choice == 'n'){
                    return false;
                }else{
                    eraseLine(1);
                }
            }while(true);
            
        }catch(Exception e){
            eraseLine(1);
        }
        
        return false;
    }


    /* Pause screen for watching printed text */
    public static void pause(){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
