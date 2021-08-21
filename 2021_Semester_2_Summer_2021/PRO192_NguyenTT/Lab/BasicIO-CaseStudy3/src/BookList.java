import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

public class BookList extends Vector<Book> {
    Scanner sc = new Scanner(System.in);

    public void loadBookFromFile(String fname) {
        if (this.size() > 0) {
            this.clear();
        }
        try {
            File f = new File(fname);
            if (!f.exists())
                return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Book b;
            while ((b = (Book) (fo.readObject())) != null) {
                this.add(b);
            }
            fo.close();
            fi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile(String fname) {
        if (this.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        try {
            FileOutputStream f = new FileOutputStream(fname);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Book x : this) {
                fo.writeObject(x);
            }
            fo.close();
            f.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewBook() {
        String title;
        int price = 0;
        System.out.println("Enter new book's detail: ");
        boolean valid = false;
        do {
            System.out.print("Tile: ");
            title = sc.nextLine();
            if (title.isEmpty()) {
                System.out.println("The title must not be empty!");

            } else {
                valid = true;
            }
        } while (!valid);

        valid = false;
        do {
            System.out.print("Price: ");
            try {
                price = Integer.parseInt(sc.nextLine());
                if (price < 0) {
                    System.out.println("Price must not lower than zero!");
                } else {
                    valid = true;
                }
            } catch (Exception ex) {
                System.out.println("Price is not valid!");
            }
        } while (!valid);

        this.add(new Book(title, price));
        System.out.println("New book has been added.");
    }

    public void print() {
        if (this.size() == 0) {
            System.out.println("Empty List");
            return;
        }
        System.out.println("ITEM IN LIST: ");
        for (Book x : this) {
            x.print();
        }
    }

}
