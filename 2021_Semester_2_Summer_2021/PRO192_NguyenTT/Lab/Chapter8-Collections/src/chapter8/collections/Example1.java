/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter8.collections;

import java.util.ArrayList;

/**
 *
 * @author jaydentran1909
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Python");
        
        System.out.println("Các phần tử có trong list là:");
//        for(int i = 0; i < list.size();i++){
//            System.out.println(list.get(i));
//        }
        for(String s: list){
            System.out.println(s);
        }
    }
}
