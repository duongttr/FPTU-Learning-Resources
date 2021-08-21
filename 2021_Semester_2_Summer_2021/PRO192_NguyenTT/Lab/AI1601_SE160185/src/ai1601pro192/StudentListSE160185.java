/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai1601pro192;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.function.Predicate;

/**
 *
 * @author jaydentran1909
 */
public class StudentListSE160185 extends Vector<StudentSE160185> {

    public StudentListSE160185() {
    }
    
    public void addStudent(){
        int pos = -1;
        String code, name;
        int gender, age;
        double score;
        do{
            code = InputterSE160185.getString("Mã số: ", true, true).toUpperCase();
            pos = find(code);
            if(pos != -1){
                System.out.println("Code is duplicated");
            }
        }while(pos != -1);
        name = InputterSE160185.getString("Tên: ", true, true).toUpperCase();
        gender = InputterSE160185.getIntWithCondition("Giới tính (0: nam, 1: nữ): ", true, new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t == 0 || t == 1;
            }
        });
        age = InputterSE160185.getIntWithCondition("Tuổi: ", true, new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 0 && t < 150;
            }
        });
        score = InputterSE160185.getDoubleWithCondition("Điểm: ", true, new Predicate<Double>() {
            @Override
            public boolean test(Double t) {
                return t >= 0.0 && t <= 10.0;
            }
        });
        
        this.add(
                new StudentSE160185(code, name, gender, age, score)
        );
        System.out.println("Thêm sinh viên thành công!");
    }
    
    public void removeStudent(){
        if(size() == 0){
            System.out.println("Empty list!");
        }else{
            String code = InputterSE160185.getString("Mã số SV muốn xoá: ", true, true).toUpperCase();
        int pos = find(code);
        if(pos != -1){
            this.remove(pos);
            System.out.println("Xoá thành công!");
        }else{
            System.out.println("Sinh viên này không tồn tại!");
        }
        }
        
    }
    
    public void editStudent(){
        if(size() == 0){
            System.out.println("Empty list!");
        }else{
          String name;
        int gender, age;
        double score;
        String code = InputterSE160185.getString("Mã số: ", true, true).toUpperCase();
        int pos = find(code);
        if(pos != -1){
            StudentSE160185 st = this.get(pos);
            name = InputterSE160185.getString("Tên: ", true, true).toUpperCase();
        gender = InputterSE160185.getIntWithCondition("Giới tính (0: nam, 1: nữ): ", true, new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t == 0 || t == 1;
            }
        });
        age = InputterSE160185.getIntWithCondition("Tuổi: ", true, new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 0 && t < 150;
            }
        });
        score = InputterSE160185.getDoubleWithCondition("Điểm: ", true, new Predicate<Double>() {
            @Override
            public boolean test(Double t) {
                return t >= 0.0 && t <= 10.0;
            }
        });
        
        st.setName(name);
        st.setAge(age);
        st.setGender(gender);
        st.setScore(score);
        System.out.println("Chỉnh sửa thông tin thành công!");
        }else{
            System.out.println("Sinh viên này không tồn tại!");
        }  
        }
        
    }
    
    public void sortAndPrintStudent(){
        Collections.sort(this, new Comparator<StudentSE160185>() {
            @Override
            public int compare(StudentSE160185 o1, StudentSE160185 o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for(StudentSE160185 st: this){
            System.out.format("%-7s|%-15s|%-6s|%-3s|%-4s\n",
                        st.getCode(),
                        st.getName(),
                        st.getGenderAsString(),
                        st.getAge() + "",
                        st.getScore() + "");
        }
        
    }
    
    public void saveToFile(String fileName) {
        if (size() == 0) { // If there's no data in list
            System.out.println("Empty list!");
        } else {
            try {
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f);
                BufferedWriter pw = new BufferedWriter(fw);
                for (StudentSE160185 e : this) {
                    // Write data into file
                    pw.write(e.toString());
                    pw.write("\n");
                }
                pw.close();
                fw.close();
                System.out.println("Lưu file thành công!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    private int find(String code){
        for(int i = 0; i < this.size();i++){
            if(this.get(i).getCode().equals(code)){
                return i;
            }
        }
        return -1;
    }
    
}
