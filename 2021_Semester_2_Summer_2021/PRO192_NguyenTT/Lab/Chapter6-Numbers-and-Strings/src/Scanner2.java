
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
public class Scanner2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String S = "Anh hùng khôn quá mỹ nhân quan";
        Scanner sc1 = new Scanner(S);
        while(sc1.hasNext()){
            System.out.println(sc1.next());
        }
        System.out.println();
        String S2 = "abc   123 556.78";
        Scanner sc2 = new Scanner(S2);
        System.out.println(sc2.next());
        System.out.println(sc2.nextInt());
        System.out.println(sc2.nextDouble());
        System.out.println();
        String S3 = "   Now are    you!  ";
        String delim = "[au\\s]+";
        Scanner sc3 = new Scanner(S3);
        sc3.useDelimiter(delim);
        while(sc3.hasNext()){
            System.out.println(sc3.next());
        }
    }
}
