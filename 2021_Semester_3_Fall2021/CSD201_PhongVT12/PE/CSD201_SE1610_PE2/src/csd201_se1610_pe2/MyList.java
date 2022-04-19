/* 
    This program contains 2 parts: (1) and (2)
    YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
*/

package csd201_se1610_pe2;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class MyList {  
//===========================================================================
//(1)=========== DO NOT EDIT THIS PART === DO NOT EDIT THIS PART ============ 
//===========================================================================    
    Node head, tail;    
    Scanner sc = new Scanner(System.in);  
    
    public MyList() {head=tail=null;}
    
    //return true if the list is empty, otherwise return false
    boolean isEmpty() {return head == null;}
    
    //clear the list
    void clear() {head=tail=null;}
         
    //load data from book.txt to the list
    void loadData() {
        try {
            //open book.txt for reading
            LineNumberReader lnr = new LineNumberReader(
                    new FileReader("book.txt"));
            String s;
            while(true) {
                s = lnr.readLine();
                if(s == null) break;
                if(s.trim().isEmpty()) continue;
                String [] st = s.trim().split("#");
                String code = st[0].trim();
                String name = st[1].trim();
                String author = st[2].trim();
                double price = Double.valueOf(st[3].trim());
                Book book = new Book(code, name, author, price);
                Node p = new Node(book);
                if(isEmpty()) {
                    head = tail = p;
                } else {
                    tail.next = p;
                    tail = p;
                }
            }
            lnr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//===========================================================================
//(2) ==== YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART =====
//===========================================================================    
    //return the first node which data=x, otherwise return null
    Node find(String x) {
        Node p = head;
        while(p!=null && !p.info.code.equals(x)) 
            p = p.next;
        if(p!=null) return p;
        return null;
    }
    // Note: You do not need to edit this function. Your task is to use it 
    // to complete other functions.
    
    //traverse the list
    void traverse() {
        // Traverse from head to tail and dislay info of all nodes 
        // (books) in the list.
        if(isEmpty()) System.out.println("  List of books is empty!");
        else{
            Node tmpHead = head;
            while(tmpHead != null){
                Book book = tmpHead.info;
                System.out.println("    "+book.toString());
                tmpHead = tmpHead.next;
            }
        }
    }
    
    //add new book
    public void addNewBook() {
        // Add a new book with newCode, newName, author, price 
        // at the tail of  a list.
        
        String newCode, newName, newAuthor;
        double newPrice;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("  Input book code = ");
            while(find(newCode = sc.nextLine().trim()) != null){
                System.out.println("        This book code existed!");
                do {
                    System.out.print("        Do you want to continue? (Y/N): ");
                    String choice = sc.nextLine().trim();
                    if (choice.toUpperCase().equals("Y")) {
                        System.out.print("  Input book code = ");
                        break;
                    } else if (choice.toUpperCase().equals("N")) {
                        return;
                    }
                } while (true);
            }

        System.out.print("  Input book name = ");
        while((newName = sc.nextLine().trim()).isEmpty()){
            System.out.println("        Book name can't be empty!");
            System.out.print("  Input book name = ");
        }

        System.out.print("  Input book author = ");
        while((newAuthor = sc.nextLine().trim()).isEmpty()){
            System.out.println("        Book name can't be empty!");
            System.out.print("  Input book author = ");
        }

        
        while(true){
            System.out.print("  Input book price = ");
            try{
                newPrice = Double.parseDouble(sc.nextLine());
                if(newPrice <= 0){
                    System.out.println("        Price must be positive!");
                }else{
                    break;
                }
            }catch(Exception ex){
                System.out.println("        Input price is invalid!");
            }
        }

        Book newBook = new Book(newCode, newName, newAuthor, newPrice);
        

        addLast(newBook);
    }
    
    //add a new node to the end
    void addLast(Book f) {
        // Add a new book with newCode, newName, author, price 
        // at the tail of  a list.
        Node newNode = new Node(f);
        if(isEmpty()){
            head = newNode;
            tail = head;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
       
    //update a book
    void updateBook() {   
        // Update the price of a book by book code
        if(isEmpty()) {
            System.out.println("  List of books is empty!");
            return;
        }

        String code;
        double newPrice;
        Node retNode;
        Scanner sc = new Scanner(System.in);
        System.out.print("  Input book code to update = ");
        while((retNode = find(code = sc.nextLine().trim().toUpperCase())) == null){
            if(code.isEmpty()) System.out.println("        Input code can't be empty!");
            else System.out.println("        This code " + code + " does not exist!");

            do {
                System.out.print("        Do you want to continue? (Y/N): ");
                String choice = sc.nextLine().trim();
                if (choice.toUpperCase().equals("Y")) {
                    System.out.print("  Input book code to update = ");
                    break;
                } else if (choice.toUpperCase().equals("N")) {
                    return;
                }
            } while (true);
        }

        System.out.println("        Book name is: " + retNode.info.name);
        System.out.println("        Book author is: " + retNode.info.author);
        System.out.println("        Old price is: " + retNode.info.price);
        
        while(true){
            System.out.print("  Input price to update = ");
            try{
                newPrice = Double.parseDouble(sc.nextLine());
                if(newPrice <= 0){
                    System.out.print("      Price must be positive!");
                }else{
                    break;
                }
            }catch(Exception ex){
                System.out.println("        Input price is invalid!");
            }
        }

        retNode.info.price = newPrice;
    }
    
    //remove a book
    void removeBook() {
        // Delete a book by book code
        if(isEmpty()) {
            System.out.println("  List of books is empty!");
            return;
        }

        String code;
        Node retNode;
        Scanner sc = new Scanner(System.in);
        System.out.print("  Input book code to remove = ");
        while((retNode = find(code = sc.nextLine().trim().toUpperCase())) == null){
            if(code.isEmpty()) System.out.println("        Input code can't be empty!");
            else System.out.println("        This code " + code + " does not exist!");

            do {
                System.out.print("        Do you want to continue? (Y/N): ");
                String choice = sc.nextLine().trim();
                if (choice.toUpperCase().equals("Y")) {
                    System.out.print("  Input book code to remove = ");
                    break;
                } else if (choice.toUpperCase().equals("N")) {
                    return;
                }
            } while (true);
        }

        System.out.println("        Book name is: " + retNode.info.name);
        System.out.println("        Book author is: " + retNode.info.author);
        System.out.println("        Book price is: " + retNode.info.price);

        do {
            System.out.print("        Are you sure you want to delete this node? (Y/N): ");
            String choice = sc.nextLine().trim();
            if (choice.toUpperCase().equals("Y")) {
                remove(retNode);
                break;
            } else if (choice.toUpperCase().equals("N")) {
                break;
            }
        } while (true);
    }
    
    //remove a given node in the list
    void remove(Node p) {
        // Delete a book by book code
        Node currNode = head;
        Node prevNode = null;

        while(currNode != p){
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(currNode == head)
            head = head.next;
        else if(currNode == tail)
            {
                tail = prevNode;
                prevNode.next = null;
            }
        else
            prevNode.next = currNode.next;
    }
    
    //sort books by book’s code
    void sort() {
        // Sort the list in ascending order by book code using 
        // selection sort algorithm.
        if(isEmpty()) {
            System.out.println("  List of books is empty!");
            return;
        }

        Node tmpNode = head;
 
        while (tmpNode != null) {
            Node minNode = tmpNode;
            Node currNode = tmpNode.next;
    
            while (currNode != null) {
                if (minNode.info.code.compareTo(currNode.info.code) > 0)
                    minNode = currNode;
                currNode = currNode.next;
            }
    
            // Swap Data
            Book x = tmpNode.info;
            tmpNode.info = minNode.info;
            minNode.info = x;
            tmpNode = tmpNode.next;
        }
    }
}
