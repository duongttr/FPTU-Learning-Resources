/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class Person {
    private String code;
    private String name;
    private int age;
    
    public Person(){
        this.code = "";
        this.name = "";
        this.age = 0;
    }

    public Person(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the person code: ");
        code = sc.nextLine();
        System.out.print("Enter the person's name: ");
        name = sc.nextLine();
        System.out.print("Enter the person's age: ");
        age = sc.nextInt();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", code, name, age);
    }
    
    
}
