/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author jaydentran1909
 */
public class FPTUni extends University implements Role{
    String address;

    public FPTUni(String name) {
        super(name);
    }

    public FPTUni(String name, int size) {
        super(name, size);
    }

    public FPTUni(String address, String name, int size) {
        super(name, size);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FPTU has four campuses Hanoi, HCM, DaNang, CanTho, QuyNhon"; 
    }

    @Override
    public void createWorker() {
        System.out.println("providing human resources");
    }
    
    
}
