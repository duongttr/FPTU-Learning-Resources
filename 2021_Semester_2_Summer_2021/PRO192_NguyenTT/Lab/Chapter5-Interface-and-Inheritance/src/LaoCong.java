/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class LaoCong extends NhanVien{
    private double gioLamViec;

    public LaoCong(double gioLamViec, String hoTen, double luong) {
        super(hoTen, luong);
        this.gioLamViec = gioLamViec;
    }
    
    public double getThuNhap(){
        return this.gioLamViec * super.luong;
    }
    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Lương: " + getThuNhap());
    }
}
