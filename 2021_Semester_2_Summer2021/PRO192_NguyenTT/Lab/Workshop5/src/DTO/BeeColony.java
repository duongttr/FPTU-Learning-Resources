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
public class BeeColony extends Colony implements Role {

    String type;

    public BeeColony(String place) {
        super(place);
    }

    public BeeColony(String place, int size) {
        super(place, size);
    }

    public BeeColony(String type, String place, int size) {
        super(place, size);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "The colony’s type is "  + type + ", size is about " + size + ", and the place is "+ place;
    }

    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
                
    }
    
    

}
