import Structures.Queue;
import Structures.Stack;
import Utils.Print;

public class Q3 {
    public static void main(String[] args) throws Exception {
        Stack<String> s = new Stack<>();
        s.push("Duong");
        s.push("Hung");
        s.push("Kiet");
        s.push("Thien");
        s.push("Dung");
        s.push("Hao");
        s.push("Nam");

        Print.print("Initial stack:");
        s.traverse();

        Print.print("Pop: ");
        s.pop();
        s.traverse();

        Print.print("Current top: ");
        System.out.println(s.top());

        Queue<String> q = new Queue<>();
        q.enqueue("Duong");
        q.enqueue("Hung");
        q.enqueue("Kiet");
        q.enqueue("Thien");
        q.enqueue("Dung");
        q.enqueue("Hao");
        q.enqueue("Nam");

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
