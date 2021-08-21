/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai1601pro192;

import java.io.Serializable;

/**
 *
 * @author jaydentran1909
 */
public class StudentSE160185 implements Serializable {
    private String code;
    private String name;
    private int gender; // 0 if male, 1 if female
    private int age; // > 0
    private double score; // >= 0 and <= 10

    public StudentSE160185(String code, String name, int gender, int age, double score) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public String getGenderAsString(){
        if(gender == 0) return "NAM";
        return "NỮ";
    }

    @Override
    public String toString() {
        return code+","+name+","+gender+","+age+","+score;
    }
    
    
    
}
