package Structures;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<E>{
    private LinkedList<E> ll;

    public Stack(){
        ll = new LinkedList<E>();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }

    public void clear(){
        ll.clear();
    }

    public void push(E x){
        ll.push(x);
    }

    public E pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        return ll.pop();
    }

    public E top() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
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