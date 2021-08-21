
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
public class Part2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the first number: ");
        float a = sc.nextFloat();
        System.out.print("Input the second number: ");
        float b = sc.nextFloat();
        sc = new Scanner(System.in);
        System.out.print("Input the operator(+ - * /): ");
        String c = sc.nextLine();
        
        float res = 0;
        switch(c){
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if(b != 0){
                    res = a / b;
                }else{
                    System.out.println("Dividend cannot be zero!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("The operator is not valid");
                System.exit(0);
        }
        
        System.out.format("The result of %f%s%f=%f\n",a,c,b,res);
        
    }
}
