
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
public class Part1 {
    public static void main(String[] args){
        int rows;
        int cols;
        int matrix[][];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        while((rows = sc.nextInt()) <= 0){
            if(rows <= 0){
                System.out.println("No of rows must be greater than zero!");
            }
        }
        System.out.print("Enter the number of cols: ");
        while((cols = sc.nextInt()) <= 0){
            if(cols <= 0){
                System.out.println("No of rows must be greater than zero!");
            }
        }
        matrix = new int[rows][cols];
        System.out.println("Enter the matrix: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.format("m[%d][%d]=",i,j);
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix inputted: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.format("%3d",matrix[i][j]);
            }
            System.out.println("");
        }
        int sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sum += matrix[i][j];
            }
        }
        double avg = (double)sum / (rows * cols);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}
