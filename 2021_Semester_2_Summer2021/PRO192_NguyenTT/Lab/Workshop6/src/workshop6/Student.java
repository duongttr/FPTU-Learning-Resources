/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6;

/**
 *
 * @author jaydentran1909
 */
public class Student implements Comparable<Student>{
    private String code;
    private String name;
    private int mark;

    public Student() {
        code = "";
        name = "";
        mark = 0;
    }

    public Student(String code, String name, int mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim().toUpperCase();
        if (name.length() > 0)
            this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark >= 0 && mark <= 10)
            this.mark = mark;
    }

    @Override
    public String toString() {
        return this.code + " - " + this.name + " - " + this.mark;
    }

    @Override
    public int compareTo(Student o) {
        return this.code.compareTo(o.getCode());
    }

    

}
