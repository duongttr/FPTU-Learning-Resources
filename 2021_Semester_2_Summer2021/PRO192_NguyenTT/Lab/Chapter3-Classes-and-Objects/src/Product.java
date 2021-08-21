
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydentran1909
 */
public class Product {
    private String maSP;
    private String tenSP;
    private String donviTinh;
    private String quiCach;
    private Date NSX;

    
    public void input(String maSP, String tenSP, String donviTinh, String quiCach, Date NSX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donviTinh = donviTinh;
        this.quiCach = quiCach;
        this.NSX = NSX;
    }
    
    public void output(){
        System.out.println("Mã Sản Phẩm: " + maSP);
        System.out.println("Tên Sản Phẩm: " + tenSP);
        System.out.println("Đơn Vị Tính: " + donviTinh);
        System.out.println("Qui Cách: " + quiCach);
        System.out.println("NSX: " + NSX.toString());
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonviTinh(String donviTinh) {
        this.donviTinh = donviTinh;
    }

    public void setQuiCach(String quiCach) {
        this.quiCach = quiCach;
    }

    public void setNSX(Date NSX) {
        this.NSX = NSX;
    }
    
    
}
