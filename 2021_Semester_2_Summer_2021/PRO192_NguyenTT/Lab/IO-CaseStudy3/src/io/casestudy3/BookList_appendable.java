import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

public class BookList_appendable extends Vector<Book>{
    Scanner sc=new Scanner(System.in);
    public void loadBookFromFile(String fname){
        if (this.size()>0) {
            this.clear();
        }
        try{
            File f=new File(fname);
            if (!f.exists()) return;
            FileInputStream  fi=new FileInputStream(f);
            ObjectInputStream fo=new ObjectInputStream(fi);
            Book b;
            while(  (b=(Book)(fo.readObject()))!=null){
                this.add(b);
            }
            fo.close();
            fi.close();
        }
        catch(Exception e){
            // System.out.println(e);
        }
    }
    public void saveToFile(String fname){
        if (this.size()==0) {
            System.out.println("Nothing to save");
            return;
        }
        try  {
            
            for(Book x:this){
                write(x, fname);
            }
            this.clear();

        } catch (Exception e) {
            // System.out.println(e);
            //TODO: handle exception
        }
    }
    public void addNewBook(){
        String title;
        int price;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new book's detail: ");
        System.out.print("Tile: ");
        title=sc.nextLine();
        System.out.print("Price: ");
        price=sc.nextInt();
        this.add(new Book(title,price));
        System.out.println("New book has been added.");
    } 
    public void print(){
        if (this.size()==0){
            System.out.println("Empty List");
            return;
        }
        System.out.println("ITEM IN LIST: ");
        for(Book x:this){
            x.print();
        }
    }
    public void print_lib(String fname){
        // this.clear();
        BookList_appendable lib_list=new BookList_appendable();
        lib_list.loadBookFromFile(fname);
        if (lib_list.size()==0){
            System.out.println("Empty List");
            return;
        }
        System.out.println("ITEM IN LIST: ");
        for(Book x:lib_list){
            x.print();
        }
    }
    public boolean hasObject(File f) {
        // thu doc xem co object nao chua
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();
 
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
    public void write(Book s,String fname) {
        try {
 
            File f = new File(fname);
            FileOutputStream fo;
            ObjectOutputStream oStream = null;
 
            // neu file chu ton tai thi tao file va ghi binh thuong
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai
 
                // neu chua co thi ghi binh thuong
                if (!hasObject(f)) {
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao
 
                    fo = new FileOutputStream(f, true);
 
                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }
 
            oStream.writeObject(s);
            oStream.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
