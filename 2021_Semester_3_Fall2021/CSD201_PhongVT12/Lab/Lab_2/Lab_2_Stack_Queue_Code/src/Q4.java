import Structures.Queue;
import Structures.Stack;
import Utils.Print;

public class Q4 {
    public static void main(String[] args) throws Exception {
        Stack<Character> s = new Stack<>();
        s.push('D');
        s.push('E');
        s.push('C');
        s.push('A');
        s.push('B');
        s.push('N');
        s.push('M');

        Print.print("Initial stack:");
        s.traverse();

        Print.print("Pop: ");
        s.pop();
        s.traverse();

        Print.print("Current top: ");
        System.out.println(s.top());

        Queue<Character> q = new Queue<>();
        q.enqueue('D');
        q.enqueue('E');
        q.enqueue('C');
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('N');
        q.enqueue('M');

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
