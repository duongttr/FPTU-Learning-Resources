/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class NhanVien {
    String hoTen;
    double luong;

    public NhanVien(String hoTen, double luong) {
        this.hoTen = hoTen;
        this.luong = luong;
    }
    
    public double getThuNhap(){
        return this.luong * 0.1;
    }
    
    public void xuat(){
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Lương: " + luong);
        System.out.println("Thuế thu nhập: " + getThuNhap());
    }
}
