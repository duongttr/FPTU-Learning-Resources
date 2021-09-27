import java.util.LinkedList;
public class Queue<E> {
    private LinkedList<E> ll;

    public Queue(){
        ll = new LinkedList<E>();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }

    public void clear(){
        ll.clear();
    }

    public void enqueue(E x){
        ll.add(x);
    }

    public E dequeue() throws Exception{
        if(isEmpty()) throw new Exception();
        
        return ll.removeFirst();
    }

    public E first() throws Exception{
        if(isEmpty()) throw new Exception();
        return ll.getFirst();
    }

    public void traverse(){
        for(E e: ll){
            System.out.print(e.toString() + " ");
        }
        System.out.println("(size: "+ll.size()+ ")");
    }

    public void print(){
        for(E e: ll){
            System.out.print(e + "");
        }
        System.out.println();
    }
}
