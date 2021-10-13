import java.util.Comparator;

import LinkedList.SinglyLinkedList;
import LinkedList.SinglyLinkedList.Node;
import Utils.Operator;
import Utils.Print;

public class App {

    public static void main(String[] args) throws Exception {
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return o1.compareTo(o2);
            }

        };

        Operator<Integer> operator = new Operator<Integer>() {

            @Override
            public Integer sum(Integer o1, Integer o2) {
                return o1 + o2;
            }

            @Override
            public Double divide(Integer o1, int size) {
                return Double.parseDouble(o1.toString()) / size;
            }

        };

        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>(comparator, operator);
        
        ll.addToHead(20);
        Node<Integer> test = ll.addToTail(10);

        ll.addToTail(5);
        ll.addToTail(2);
        ll.addToTail(1);
        ll.addToTail(11);
        ll.addToTail(99);
        ll.addToTail(100);
        
        Print.print("Initial: ");
        ll.traverse();

        Print.print("Add 30 after 10: ");
        ll.addAfter(test, 30);
        ll.traverse();
        Print.print("Add 40 before 10: ");
        ll.addBefore(test, 40);
        ll.traverse();

        Print.print("Delete head and tail: ");
        ll.deleteFromHead();
        ll.deleteFromTail();

        ll.traverse();

        Print.print("Delete after 10: ");
        ll.deleteAfter(test);

        ll.traverse();

        Print.print("Delete first node with value 20: ");
        ll.deleteNode(20);

        ll.traverse();

        Print.print("Reverse linked list: ");
        ll.reverse();
        ll.traverse();

        Print.print("Sorting: ");
        ll.sort();
        ll.traverse();

    }

}
