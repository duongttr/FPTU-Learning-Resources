/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentlabcollection;

import java.util.*;

/**
 *
 * @author jaydentran1909
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------ASSIGNMENT 2------------");
        System.out.print("Nhập chuỗi: ");
        String inputText = sc.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < inputText.length();i++){
            map.put(inputText.charAt(i), i+1);
        }
        System.out.println("Vị trí cuối cùng của các kí tự phân biệt trong chuỗi là: ");
        for(var entry: map.entrySet()){
            System.out.format("'%c': %d\n", entry.getKey(), entry.getValue());
        }
    }
}
