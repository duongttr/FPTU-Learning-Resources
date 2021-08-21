/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai1601pro192;

/**
 *
 * @author jaydentran1909
 */
public class StudentManagerSE160185 {

    public static void main(String args[]) {
        String fName = "sinhvien.txt";
        MenuSE160185 menu = new MenuSE160185();
        menu.add("Thêm sinh viên mới");
        menu.add("Xoá một sinh viên");
        menu.add("Chỉnh sửa thông tin sinh viên");
        menu.add("Hiển thị ra màn hình danh sách sinh viên được sắp xếp tăng dần");
        menu.add("Ghi danh sách sinh viên xuống file");
        menu.add("Thoát");
        
        int choice = -1;
        StudentListSE160185 list = new StudentListSE160185();
        while(choice != 6){
           choice = menu.getUserChoice();
           switch(choice){
            case 1:
                list.addStudent();
                break;
            case 2:
                list.removeStudent();
                break;
            case 3:
                list.editStudent();
                break;
            case 4:
                list.sortAndPrintStudent();
                break;
            case 5:
                list.saveToFile(fName);
                break;
            case 6:
                break;
            } 
        }
    }
}
