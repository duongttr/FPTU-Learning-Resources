/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

/**
 *
 * @author jaydentran1909
 */
public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a[] =  {1,2,3,4,5};
        GenericArray obj1 = new GenericArray();
        obj1.output(a);
        System.out.println(GenericArray.get(3,a));
        Double b[] = {1.1, 2.2, 3.3, 4.4};
        GenericArray<Double> obj2 = new GenericArray<Double>();
        obj2.output(b);
        String list[] = {"you", "love", "I"};
        GenericArray<String> obj3 = new GenericArray<String>();
        obj3.output(list);
        obj3.sort(list);
        obj3.output(list);
    }
    
}
