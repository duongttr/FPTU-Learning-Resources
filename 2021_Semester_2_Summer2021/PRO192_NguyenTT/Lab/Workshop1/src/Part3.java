
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
public class Part3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        String[] list = new String[n];
        for(int i = 0; i < n;i++){
            sc = new Scanner(System.in);
            System.out.format("list[%d]: ", i);
            list[i] = sc.nextLine();
        }   
        
        System.out.print("Uppercase name: \n");
        for(int i = 0; i < n;i++){
            System.out.println(capitalizeFully(list[i]));
        }
    }
    
    public static String capitalizeFully(String s){
        s = s.replaceAll("\\s+", " ").trim();
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length; i++){
            ss[i] = ss[i].substring(0, 1).toUpperCase() + ss[i].substring(1).toLowerCase();
        }
        return String.join(" ", ss);
    }
}
