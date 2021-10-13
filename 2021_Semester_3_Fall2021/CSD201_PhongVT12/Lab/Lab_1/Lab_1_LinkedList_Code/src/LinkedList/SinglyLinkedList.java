package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;

import Utils.Operator;

public class SinglyLinkedList<E> {
    public static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Comparator<E> comparator;
    private Operator<E> operator;

    public SinglyLinkedList(Comparator<E> comparator, Operator<E> operator) {
        this.comparator = comparator;
        this.operator = operator;
    }

    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> addToHead(E e) {
        head = new Node<E>(e, head);
        if (isEmpty())
            tail = head;
        size++;

        return head;
    }

    public Node<E> addToTail(E e) {
        Node<E> newest = new Node<E>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;

        return newest;
    }

    public Node<E> addAfter(Node<E> p, E x) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else if (p == null) {
            throw new Exception("Input node is empty!");
        } else {
            Node<E> newest = new Node<E>(x, null);
            if (p.getNext() == null) {
                p.setNext(newest);
                tail = newest;
            } else {
                newest.setNext(p.getNext());
                p.setNext(newest);
            }
            size++;

            return newest;
        }
    }

    public ArrayList<E> toArrayList() {
        ArrayList<E> ret = new ArrayList<E>();
        Node<E> tmp = head;
        while (tmp != null) {
            ret.add(tmp.getElement());
            tmp = tmp.getNext();
        }
        return ret;
    }

    public void traverse() {
        Node<E> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getElement() + " ");
            tmp = tmp.getNext();
        }
        System.out.println("(size: " + size + ")");
    }

    public int count() {
        return size;
    }

    public void deleteFromHead() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            head = head.getNext();
            size--;
        }

    }

    public void deleteFromTail() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            if (size == 1) {
                head = null;
            } else if (size > 1) {
                Node<E> tmp = head;
                while (tmp.getNext().getNext() != null) {
                    tmp = tmp.getNext();
                }
                tmp.setNext(null);
                tail = tmp;
            }
            size--;
        }
    }

    public void deleteAfter(Node<E> p) throws Exception {
        if (isEmpty() || size == 1) {
            throw new Exception("List is empty or has only 1 node!");
        } else if (p == null) {
            throw new Exception("Input node is null!");
        } else if (p.getNext() == null) {
            // next element is null
        } else {
            Node<E> tmp = head;
            while (tmp != p) {
                tmp = tmp.getNext();
            }
            tmp.setNext(tmp.getNext().getNext());
            tail = tmp.getNext();
            size--;
        }
    }

    // delete first node with value x
    public void deleteNode(E x) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            if (head.getElement() == x) {
                head = head.getNext();
            } else {
                Node<E> tmp = head;
                while (tmp.getNext() != null) {
                    if (tmp.getNext().getElement() == x) {
                        break;
                    }
                    tmp = tmp.getNext();
                }
                if (tmp.getNext() != null) {
                    tmp.setNext(tmp.getNext().getNext());
                    tail = tmp.getNext();
                }
            }
            size--;
        }
    }

    public Node<E> search(E e) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            Node<E> tmp = head;
            while (tmp != null) {
                if (tmp.getElement() == e) {
                    return tmp;
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    public void delete(Node<E> p) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else if (p == null) {
            throw new Exception("Input node is null!");
        } else if (size == 1) {
            if (head == p) {
                deleteFromHead();
            }
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                if (tmp.getNext() == p) {
                    tmp.setNext(tmp.getNext().getNext());
                    if (tmp.getNext() == null)
                        tail = tmp;
                    size--;
                    return;
                }
                tmp = tmp.getNext();
            }
        }
    }

    // delete node from i-index
    public void delete2(int i) throws Exception {
        if (i < 0 && i >= size) {
            throw new Exception("Index is out-of-range");
        } else {

            if (i == 0) {
                deleteFromHead();
                return;
            }
            if (i == size - 1) {
                deleteFromTail();
                return;
            }

            Node<E> tmp = head;
            int ii = 0;
            while (ii != i - 1) {
                ii++;
                tmp = tmp.getNext();
            }
            tmp.setNext(tmp.getNext().getNext());
            if (tmp.getNext() == null)
                tail = tmp;
            size--;
        }
    }

    public Node<E> addBefore(Node<E> p, E x) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else if (p == null) {
            throw new Exception("Input node is null!");
        } else if (head == p) {
            return addToHead(x);
        } else {
            Node<E> newest = new Node<E>(x, null);
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                if (tmp.getNext() == p) {
                    newest.setNext(p);
                    tmp.setNext(newest);
                    size++;
                    return newest;
                }
                tmp = tmp.getNext();
            }

        }
        return null;
    }

    public void sort() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else if (size == 1) {
            return;
        } else {
            ArrayList<E> l = toArrayList();
            l.sort(comparator);
            Node<E> tmp = head;
            int i = 0;
            while (tmp != null) {
                tmp.setElement(l.get(i++));
                tmp = tmp.getNext();
            }
            // ne = curr.getNext();
        }
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> curr = head;
        Node<E> next = null;
        tail = head;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void mergeWith(SinglyLinkedList<E> p) {
        Node<E> A = this.head;
        Node<E> B = p.head;
        Node<E> C = merge(A, B);
        this.head = C;
        this.size += p.size;
    }

    private Node<E> merge(Node<E> A, Node<E> B) {
        if (A == null) {
            this.tail = B;
            return B;
        }
        if (B == null) {
            this.tail = A;
            return A;
        }
        if (comparator.compare(A.getElement(), B.getElement()) < 0) {
            A.setNext(merge(A.getNext(), B));
            return A;
        } else {
            B.setNext(merge(A, B.getNext()));
            return B;
        }
    }

    public void attachWith(SinglyLinkedList<E> p) {
        if (p.size > 0) {
            if (this.tail != null) {
                this.tail.setNext(p.head);
                this.tail = p.tail;
            } else {
                if (p.size > 0) {
                    this.head = p.head;
                    this.tail = p.tail;
                }
            }
        }
        size += p.size;
    }

    public boolean sorted() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            Node<E> tmp = head;
            if (tmp != null && tmp.getNext() != null) {
                if (this.comparator.compare(tmp.getElement(), tmp.getNext().getElement()) > 0) {
                    return false;
                }
            }
            tmp = tmp.getNext();
        }
        return true;
    }

    public E max() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            Node<E> tmp = head;
            E currMax = tmp.getElement();
            tmp = tmp.getNext();
            while (tmp != null) {
                if (comparator.compare(currMax, tmp.getElement()) < 0) {
                    currMax = tmp.getElement();
                }
                tmp = tmp.getNext();
            }
            return currMax;
        }
    }

    public E min() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        } else {
            Node<E> tmp = head;
            E currMin = tmp.getElement();
            tmp = tmp.getNext();
            while (tmp != null) {
                if (comparator.compare(currMin, tmp.getElement()) > 0) {
                    currMin = tmp.getElement();
                }
                tmp = tmp.getNext();
            }
            return currMin;
        }
    }

    public E sum() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        }else if(!(head.element instanceof Number)){
            throw new Exception("Data type of element in this list must be number");
        } else {
            Node<E> tmp = head;
            E s = tmp.getElement();
            tmp = tmp.getNext();
            while (tmp != null) {
                s = operator.sum(s, tmp.getElement());
                tmp = tmp.getNext();
            }
            return s;
        }
    }

    public Object avg() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty!");
        }else if(!(head.element instanceof Number)){
            throw new Exception("Data type of element in this list must be number");
        } 
        else {
            E total = sum();
            return operator.divide(total, size);
        }
    }

    public void insert(E x) {
        Node<E> newest = new Node<E>(x, null);
        if (isEmpty()) {
            head = newest;
            tail = head;
            size++;
        } else if (size == 1) {
            if (comparator.compare(x, this.head.getElement()) <= 0) {
                try {
                    addBefore(head, x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    addAfter(head, x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Node<E> tmp = head;
            while (tmp != null) {
                E v1 = tmp.getElement();
                if (tmp.getNext() != null) {
                    E v2 = tmp.getNext().getElement();
                    if (comparator.compare(v1, x) <= 0 && comparator.compare(x, v2) <= 0) {
                        newest.setNext(tmp.getNext());
                        tmp.setNext(newest);
                        size++;
                        return;
                    } else if (comparator.compare(x, v1) <= 0 && comparator.compare(x, v2) <= 0) {
                        newest.setNext(head);
                        head = newest;
                        size++;
                        return;
                    }
                } else {
                    tail.setNext(newest);
                    tail = newest;
                    size++;
                    return;
                }
                tmp = tmp.getNext();
            }
        }
    }

    public boolean equals(SinglyLinkedList<E> p) {
        if (p.size != this.size) {
            return false;
        } else {
            Node<E> tmp = head;
            Node<E> tmp2 = p.head;
            while (tmp != null && tmp2 != null) {
                if (comparator.compare(tmp.getElement(), tmp2.getElement()) != 0)
                    return false;
                tmp = tmp.getNext();
                tmp2 = tmp2.getNext();
            }
        }
        return true;
    }
}
