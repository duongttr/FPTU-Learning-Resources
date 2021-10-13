import Structures.DecToBin;
import Structures.Queue;
import Structures.Stack;
import Utils.Print;

public class Q1_2 {
    public static void main(String[] args) throws Exception {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        Print.print("Initial stack:");
        s.traverse();

        Print.print("Pop: ");
        s.pop();
        s.traverse();

        Print.print("Current top: ");
        System.out.println(s.top());

        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);

        System.out.println();

        Print.print("Initial queue:");
        q.traverse();

        Print.print("Dequeue: ");
        q.dequeue();
        q.traverse();

        Print.print("First: ");
        System.out.println(q.first());
        
        System.out.println();

        Print.print("Decimal to binary (integer):");
        DecToBin.convertInteger(2020202);
        Print.print("Decimal to binary (< 1):");
        DecToBin.convertLessThanOne(0.475);
    }
}
