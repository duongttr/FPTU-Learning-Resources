package assignmentlabcollection.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Assignment4 {
    private static List<PhanSo> dsPhanSo = new ArrayList<>();
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem("Thêm phân số",
                    "In các phân số",
                    "So sánh phân số trong danh sách và phân số tự nhập",
                    "Số lượng phân số riêng biệt trong danh sách và số lần xuất hiện",
                    "Sắp xếp phân số",
                    "Thoát");
        while(true){
            System.out.print("\n\n\n\n\n");
            int choice = menu.getUserChoice();
            switch(choice){
                case 1:
                    themPhanSo();
                    break;
                case 2:
                    a();
                    break;
                case 3:
                    b();
                    break;
                case 4:
                    c();
                    break;
                case 5:
                    d();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void themPhanSo(){
        Scanner sc = new Scanner(System.in);
        int tuSo, mauSo;
        while(true){
            try{
                System.out.print("Tử số: ");
                tuSo = Integer.parseInt(sc.nextLine());
                break;
            }catch(Exception ex){
                System.out.println("Tử số không hợp lệ, hãy nhập số nguyên!");
            }
        }

        while(true){
            try{
                System.out.print("Mẫu số: ");
                mauSo = Integer.parseInt(sc.nextLine());
                if(mauSo == 0){
                    System.out.println("Mẫu số không thể bằng 0!");
                    continue;
                }
                break;
            }catch(Exception ex){
                System.out.println("Tử số không hợp lệ, hãy nhập số nguyên!");
            }
        }
        dsPhanSo.add(new PhanSo(tuSo, mauSo));
    }

    public static void a(){
        System.out.println("Danh sách các phân số: ");
        for(PhanSo ps: dsPhanSo){
            System.out.print(ps + ", ");
        }
        System.out.println();
    }

    public static void b(){
        
        Scanner sc = new Scanner(System.in);
        int tuSo, mauSo;
        PhanSo x;
        while(true){
            try{
                System.out.print("Tử số: ");
                tuSo = Integer.parseInt(sc.nextLine());
                break;
            }catch(Exception ex){
                System.out.println("Tử số không hợp lệ, hãy nhập số nguyên!");
            }
        }

        while(true){
            try{
                System.out.print("Mẫu số: ");
                mauSo = Integer.parseInt(sc.nextLine());
                if(mauSo == 0){
                    System.out.println("Mẫu số không thể bằng 0!");
                    continue;
                }
                break;
            }catch(Exception ex){
                System.out.println("Tử số không hợp lệ, hãy nhập số nguyên!");
            }
        }
        x = new PhanSo(tuSo, mauSo);

        System.out.print("Các phân số bằng với phân số " + x + ": ");
        for(PhanSo ps: dsPhanSo){
            if(x.compareTo(ps) == 0){
                System.out.print(ps + ", ");
            }
        }
    }

    public static void c(){
        Map<PhanSo, Integer> map = new TreeMap<>();
        boolean next = false;
        for(PhanSo ps: dsPhanSo){
            next = false;
            for(PhanSo psKey: map.keySet()){
                if(ps.compareTo(psKey) == 0){
                    int c = map.get(psKey) + 1;
                    map.put(psKey, c);
                    next = true;
                }
            }
            if(next) continue;
            map.put(ps, 1);
        }
        System.out.println("Danh sách số lần xuất hiện của các phân số riêng biệt: ");
        for(Entry<PhanSo, Integer> s: map.entrySet()){
            System.out.println(s.getKey() + ": " + s.getValue());
        }
    }

    public static void d(){
        Collections.sort(dsPhanSo);
        a();
    }
}
