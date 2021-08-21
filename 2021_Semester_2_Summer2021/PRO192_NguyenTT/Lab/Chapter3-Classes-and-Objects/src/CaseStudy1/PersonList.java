/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaseStudy1;

import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class PersonList {
    private Person[] list = null;
    private int count = 0;
    
    public PersonList(int size){
        if(size < 1) size = 10;
        list = new Person[size];
    }
    
    int find(String aCode){
        for(int i = 0; i < count; i++){
            if(aCode.equals(list[i].getCode())) return i;
        }
        return -1;
    }
    
    public void add(){
        if(count == list.length) System.out.println("List is full!");
        else{
            String newCode, newName;
            int newAge;
            
            Scanner sc = new Scanner(System.in);
            int pos;
            do{
                System.out.print("Enter the person's code: ");
                newCode = sc.nextLine().toUpperCase();
                pos = find(newCode);
                if(pos >= 0) System.out.println("This code is existed!");
            }while(pos >= 0);
            
            System.out.print("Enter the person's name: ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's age: ");
            newAge = sc.nextInt(); 
            list[count++] = new Person(newCode, newName, newAge);
            System.out.println("New person has been added");
        }
    }
    
    public void remove(){
        if(count == 0){
            System.out.println("Empty list");
            return;
        }else{
            String removedCode;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the code of removed person: ");
            removedCode = sc.nextLine().toUpperCase();
            int pos = find(removedCode);
            if(pos < 0) System.out.println("This person doesn't exist.");
            else{
                for(int i = pos; i < count - 1; i++) list[i] = list[i+1];
                count--;
                System.out.println("The person " + removedCode + " was removed");
            }
        }
    }
    
    public void update(){
        if(count == 0){
            System.out.println("Empty list");
            return;
        }
        String code;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code of updated person: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos < 0) System.out.println("This person doesn't exist");
        else{
            String newName;
            int newAge;
            System.out.print("Enter the person's name: ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's age: ");
            newAge = sc.nextInt();
            list[pos].setName(newName);
            list[pos].setAge(newAge);
            System.out.println("The person " + code + " was updated");
        }
    }
    
    public void print(){
        if(count == 0){
            System.out.println("Empty list");
            return;
        }else{
            System.out.println("LIST OF PERSONS: ");
            for(int i = 0; i < count; i++){
                System.out.println(list[i].toString());
            }
        }
    }
    
    public void sort(){
        if(count == 0) return;
        for(int i = 0; i < count - 1; i++){
            for(int j = count - 1; j > i; j--){
                if(list[j].getAge() > list[j-1].getAge()){
                    Person p = list[j];
                    list[j] = list[j-1];
                    list[j-1] = p;
                }
            }
        }
    }
}
