/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_1;

import java.util.Scanner;

/**
 *
 * @author jaydentran1909
 */
public class SinhVien {
    String name;
    double score;
    String rank;

    public SinhVien() {
        input();
        sort();
        output();
    }

    public SinhVien(String name, double score) {
        this.name = name;
        this.score = score;
        sort();
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter score: ");
        this.score = sc.nextDouble();
    }
    
    public void output(){
        System.out.format("Sinh viên [%s], Điểm [%.1f], Học lực [%s]\n", name, score, rank);
    }
    
    public void sort(){
        if(score >= 8){
            rank = "Giỏi";
        }else if(score >= 6.5){
            rank = "Khá";
        }else if(score >= 5){
            rank = "Trung Bình";
        }else{
            rank = "Yếu";
        }
    }
}
