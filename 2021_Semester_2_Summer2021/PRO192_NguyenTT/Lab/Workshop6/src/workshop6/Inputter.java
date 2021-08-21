/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6;

import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    
    public static int inputInt(String msg, int min, int max){
        if(min > max){
            int t = min;
            min = max;
            max = t;
        }
        int data = min - 1;
        do{
            try{
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
            }catch(Exception ex){

            }
        }while(data < min || data > max);
        return data;
    }

    public static String inputString(String msg){
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }

    public static String inputNonBlankString(String msg){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
            
        }while(data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg, String pattern){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
        }while(!data.matches(pattern));
        return data;
    }
}
