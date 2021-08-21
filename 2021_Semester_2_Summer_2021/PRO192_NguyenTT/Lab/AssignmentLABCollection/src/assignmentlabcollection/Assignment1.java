/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentlabcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jaydentran1909
 */
public class Assignment1 {

    private static List<Integer> dsSoNguyen = new ArrayList<Integer>();
    private static int n = 10;

    public static void main(String args[]) {
        Random rand = new Random(System.currentTimeMillis());
        int neg = -100;
        int pos = 1000;
        for(int i = 0; i < n;i++){
        dsSoNguyen.add(rand.nextInt(pos - neg + 1) + neg);
        }

        // dsSoNguyen.add(1);
        // dsSoNguyen.add(2);
        // dsSoNguyen.add(3);
        // dsSoNguyen.add(5);
        // dsSoNguyen.add(8);
        // dsSoNguyen.add(13);
        // dsSoNguyen.add(21);

        System.out.println("------------ASSIGNMENT 1------------");
        System.out.println("a. Hãy in ra các giá trị trong danh sách.");
        a();
        System.out.println("\nb. Hãy tính tổng các giá trị trong danh sách");
        b();
        System.out.println("\nc. Hãy tìm số lớn nhất trong danh sách");
        c();
        System.out.println("\nd. Hãy loại ra khỏi danh sách các số là số nguyên không dương.");
        d();
        System.out.println("\ne. Hãy nghịch đảo mảng lại và xuất ra danh sách các phần tử");
        e();
        System.out.println("\nf. Hãy sắp xếp mảng theo thứ tự tăng dần và xuất ra màn hình");
        f();
        System.out.println("\ng. Với mảng đã sắp xếp, hãy tìm các phần tử bằng tổng của 2 phần tử liền trước.");
        g();
    }

    private static void a() {
        System.out.print("\u001B[1m");
        for (int i = 0; i < dsSoNguyen.size(); i++) {
            System.out.print(dsSoNguyen.get(i) + ", ");
        }
        System.out.println();
    }

    private static void b() {
        System.out.print("\u001B[1m");
        int sum = 0;
        for (int num : dsSoNguyen) {
            sum += num;
        }
        System.out.println("Tổng: " + sum);
    }

    private static void c() {
        System.out.print("\u001B[1m");
        int currMax = dsSoNguyen.get(0);
        for (int num : dsSoNguyen) {
            if (num > currMax)
                currMax = num;
        }
        System.out.println("Số lớn nhất: " + currMax);

    }

    private static void d() {
        int i = 0;
        while (i < dsSoNguyen.size()) {
            if (dsSoNguyen.get(i) <= 0) {
                dsSoNguyen.remove(i);
            } else {
                i++;
            }
        }
        a();
    }

    private static void e() {
        Collections.reverse(dsSoNguyen);
        a();
    }

    private static void f() {
        Collections.sort(dsSoNguyen);
        a();
    }

    private static void g() {
        for (int i = 2; i < dsSoNguyen.size(); i++) {
            if (dsSoNguyen.get(i) == (dsSoNguyen.get(i - 1) + dsSoNguyen.get(i - 2))) {
                System.out.print(
                        dsSoNguyen.get(i) + "(" + dsSoNguyen.get(i - 2) + "+" + dsSoNguyen.get(i - 1) + ")" + ", ");
            }
        }
    }

}
