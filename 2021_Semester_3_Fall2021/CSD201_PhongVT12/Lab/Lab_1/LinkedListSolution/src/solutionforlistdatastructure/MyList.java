/*
 *  Lab1 - List Data Structures
 */

package solutionforlistdatastructure;

public class MyList {
    Node head, tail;
    
    public MyList() {head = tail = null;}
    
    // Inserts a new node at front of the list.
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Return number of nodes in the list
    public int size() {
        Node p = head; int count = 0;
        while(p!=null) {count++; p=p.next;}
        return count;
    }
    
    // Inserts a new node after the given prev_node
    void addAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node==null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        /* 2. Allocate the Node & 3. Put in the data*/
        Node new_node = new Node(new_data);
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }
    
    void addBefore(Node given_ptr, int new_data) { 
        // First check if the given pointer is the address of head
        if(head==given_ptr) {
            Node n = new Node(new_data); // Create a new node
            n.next = head; // Point to next to current head
            head = n; // Update the head pointer
        // Otherwise, traverse the list to find previous node of given node
        } else {
            Node p = null;
            // This loop will return p with previous pointer of given node
            for(Node n=head; n!=given_ptr; p=n, n=n.next);
            // Create a new node
            Node m = new Node(new_data);
            // Update the m.next
            m.next = p.next;
            // Update previous node' s next
            p.next = m;
        }
    }
    
    void deleteAter(Node p) {
        Node prev=p, temp=p.next;
        if (temp==null) return;
        // Unlink the node from linked list
        prev.next = temp.next;
    } 
    
    // Given a key, deletes the first occurrence of key in linked list
    public void deleteNode(int key) {
        // Store head node
        Node temp=head, prev=null;
        // If head node itself holds the key to be deleted
        if (temp!=null && temp.data==key) {
            head = temp.next; // Changed head
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp!=null && temp.data!=key) {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp==null) return;
        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Return the first node which data=x, otherwise return null
    Node search(int x) {
        Node p = head;
        while(p!=null && p.data!=x) p = p.next;
        return p;
    }
    
    // Delete a node from the list
    void delete(Node p) {
        if(p==null) return;
        // find prev where prev.next = p
        Node f=head, prev=null;
        while(f!=null && f!=p) {prev=f; f=f.next;}       
        if(prev==null) { // remove head
            head = head.next;
            if(head==null) tail=null;
        } else {
            prev.next = p.next;
            if(p==tail) tail = prev;
        }
        p.next = null;
    }
       
    // Delete an i-th node on the list
    public void deleteNode2(int i) {
        Node p=head; int count=0;
        while(p!=null && count<i) {count++; p = p.next;}
        delete(p);
    }
    
    // Return a node at position i
    Node get(int i) {
        Node p=head; int count=0;
        while(p!=null && count<i) {count++; p = p.next;}
        return p;
    }
       
    // Sort the list ascending 
    public void sort() {
        int n = size();
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                Node pi=get(i), pj=get(j);
                if(pi.data > pj.data) {
                    int temp=pi.data; pi.data=pj.data; pj.data=temp;
                }
            }
        }
    }
    
    // Reverse a list
    public void reverse() {
        int n = size();
        for(int i=0,j=n-1; i<j; i++,j--) {
            Node pi=get(i), pj=get(j);
            int temp=pi.data; pi.data=pj.data; pj.data=temp;
        }
    }
    
    // This function prints contents of linked list starting 
    // from the given node
    public void printList() {
        Node tnode = head;
        while (tnode!=null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }
}
