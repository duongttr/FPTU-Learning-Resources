/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.*;

/**
 *
 * @author jaydentran1909
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Colony obj1 = new BeeColony("honey", "land", 2000); // method in BeeColony will override method in Colony
        System.out.println(obj1); // use toString() method in BeeColony
        obj1.grow(); // there's no method grow in BeeColony, so it will run method in Colony
        obj1.reproduce(); // this is also the same as grow() method.
        University obj2 = new FPTUni("FPT", "Cantho", 100000);
        System.out.println(obj2); 
        obj2.enroll(); 
        obj2.educate();
        Organization df= new BeeColony("wasp", "land", 3000); 
        System.out.println(df);
        ((BeeColony)df).createWorker();
        df = new FPTUni("FPT", "Hanoi",100000); 
        System.out.println(df);
        ((FPTUni)df).createWorker();
    }
}

/*
2. Why the Organization class is abstract?
The reason is there's a method which is abstract: communicateByTool(); which is not defined detailly in parent class.
3. Why must the Colony/University class implement the communicateBytool() method?
Because Colony and University class are inherited from an abstract class, so they need to implement all of the abstract methods in this parent.
4. You explain the polymorphism feature in your code.
We can easily see that the polymorphism feature through toString() method. toString() is an method from Object class, so every class we create, it always can implement this method.
5. Describe the difference between an interface and an abstract class.
- Abstract class can be a non-abstract and abstract. Interface is only abstract.
- Abstract class is extended with keyword "extends". Interface is implemented with keyword "implements".
- Abstract class can extend another Java class and multiple Java interface. Interface can extend another Java interface only.
*/