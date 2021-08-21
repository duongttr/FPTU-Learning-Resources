/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_1;

/**
 *
 * @author jaydentran1909
 */
public class SinhVien_Use {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SinhVien sv1 = new SinhVien();
        SinhVien sv2 = new SinhVien("Trần Văn A", 9.0);
        sv2.output();
    }
}
