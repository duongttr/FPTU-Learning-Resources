import static LinkedList.SinglyLinkedList.Node;

import java.util.Comparator;

import Intefaces.Operator;
import LinkedList.SinglyLinkedList;

public class App {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                
                return o1.compareTo(o2);
            }
            
        };

        Operator<Integer> operator = new Operator<Integer>(){

            @Override
            public Integer sum(Integer o1, Integer o2) {
                return o1+o2;
            }

            @Override
            public Double divide(Integer o1, int size) {
                return Double.parseDouble(o1.toString())/size;
            }
            
        };

        
    }
    
}
