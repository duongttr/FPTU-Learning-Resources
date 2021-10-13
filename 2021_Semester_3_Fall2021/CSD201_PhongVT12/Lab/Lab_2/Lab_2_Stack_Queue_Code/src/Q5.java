import Structures.Queue;
import Structures.Stack;
import Utils.Print;

public class Q5 {
    public static void main(String[] args) throws Exception {
        Stack<Double> s = new Stack<>();
        s.push(1.2);
        s.push(1.0);
        s.push(3.14);
        s.push(5.0);
        s.push(7.1);
        s.push(10.0);
        s.push(9.5);

        Print.print("Initial stack:");
        s.traverse();

        Print.print("Pop: ");
        s.pop();
        s.traverse();

        Print.print("Current top: ");
        System.out.println(s.top());

        Queue<Double> q = new Queue<>();
        q.enqueue(1.2);
        q.enqueue(1.0);
        q.enqueue(3.14);
        q.enqueue(5.0);
        q.enqueue(7.1);
        q.enqueue(10.0);
        q.enqueue(9.5);

        System.out.println();

        Print.print("Initial queue:");
        q.traverse();

        Print.print("Dequeue: ");
        q.dequeue();
        q.traverse();

        Print.print("First: ");
        System.out.println(q.first());
        
        System.out.println();
    }
}
