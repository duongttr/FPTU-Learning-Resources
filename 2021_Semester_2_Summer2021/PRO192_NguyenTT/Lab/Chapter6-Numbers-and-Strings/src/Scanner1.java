
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class Scanner1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner sc;
        String s = "I love you so much. I want to marry you";
        sc = new Scanner(s);
        sc.useDelimiter("[ ]");
        while(sc.hasNext()){
            String token = sc.next();
            System.out.println(token);
        }
    }
}
