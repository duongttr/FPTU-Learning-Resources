/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test2;

/**
 *
 * @author jaydentran1909
 */
class Study_1A{
    void M(){System.out.print("A");}
    void A(){System.out.print("Â");}
}

class Study_1B extends Study_1A{
    void M(){System.out.print("B");}
}

//class Study_1C{
class Study_1C extends Study_1A{
    void M(){System.out.print("C");}
    void B(){System.out.println("Ă");}
}

public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Study_1A obj = new Study_1A();
        obj.M();
        obj = new Study_1B();
        obj.M();
        Study_1A obj2 = new Study_1C();
        obj2.A();
    }
}
