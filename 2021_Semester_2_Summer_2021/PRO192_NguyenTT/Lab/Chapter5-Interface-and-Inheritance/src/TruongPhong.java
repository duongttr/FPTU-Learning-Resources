/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class TruongPhong extends NhanVien {
    private double trachNhiem;

    public TruongPhong(double trachNhiem, String hoTen, double luong) {
        super(hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Trách nhiệm: " + trachNhiem);
    }
    
    
    
}
