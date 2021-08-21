/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentlabcollection;

import java.util.*;
/**
 *
 * @author jaydentran1909
 */
public class Assignment3 {
    /**
     * @param args the command line arguments
     */
    static HashMap<String, String> dict = new HashMap<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n1. Thêm");
            System.out.println("2. Xoá");
            System.out.println("3. Sửa nghĩa");
            System.out.println("4. Tìm");
            System.out.println("5. Liệt kê");
            System.out.println("6. Thoát");
            System.out.print("------> Lựa chọn: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    addVocab();
                    break;
                case 2:
                    removeVocab();
                    break;
                case 3:
                    editVocab();
                    break;
                case 4:
                    searchVocab();
                    break;
                case 5:
                    listVocab();
                    break;
                        
            }
        }while(choice != 6);
    }

    private static void addVocab() {
        System.out.print("Từ vựng: ");
        String vocab = (new Scanner(System.in)).nextLine();
        System.out.print("Nghĩa của từ: ");
        String def = (new Scanner(System.in)).nextLine();
        dict.put(vocab.toLowerCase(), def);
    }

    private static void removeVocab() {
        System.out.print("Nhập từ bạn muốn xoá: ");
        String vocab = (new Scanner(System.in)).nextLine();
        if(dict.containsKey(vocab.toLowerCase())){
            dict.remove(vocab);
            System.out.println("Đã xoá từ vựng thành công!");
        }else{
            System.out.println("Từ này không tồn tại trong từ điền!");
        }
    }
    
    private static void editVocab(){
        System.out.print("Nhập từ bạn muốn đổi nghĩa: ");
        String vocab = (new Scanner(System.in)).nextLine();
        if(dict.containsKey(vocab.toLowerCase())){
            System.out.print("Nhập nghĩa muốn đổi: ");
            String def = (new Scanner(System.in)).nextLine();
            dict.put(vocab, def);
            System.out.println("Đã đổi nghĩa của từ vựng thành công!");
        }else{
            System.out.println("Từ này không tồn tại trong từ điền!");
        }
    }

    private static void searchVocab() {
        System.out.print("Nhập từ: ");
        String vocab = (new Scanner(System.in)).nextLine();
        if(dict.containsKey(vocab.toLowerCase())){
            System.out.format("Từ '%s' có nghĩa là '%s'\n", vocab, dict.get(vocab.toLowerCase()));
        }else{
            System.out.println("Từ này không tồn tại trong từ điền!");
        }
    }
    private static void listVocab() {
        for(var entry: dict.entrySet()){
            System.out.format("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
