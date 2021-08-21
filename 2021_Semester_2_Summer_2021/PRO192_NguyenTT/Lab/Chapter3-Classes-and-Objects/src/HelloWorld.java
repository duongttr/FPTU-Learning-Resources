
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
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Product p = new Product();
        p.input("A", "B", "VNĐ", "C", new Date(System.currentTimeMillis()));
        p.output();
    }
}
