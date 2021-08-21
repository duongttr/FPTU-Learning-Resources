import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {
        String fname = "books.dat";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("1. View books ");
        menu.add("2. Add new book ");
        menu.add("3. Save to file ");
        menu.add("4. Quit ");
        int userChoice = -1;
        BookList list = new BookList();
        list.loadBookFromFile(fname);
        while (userChoice != 4) {
            menu.show();
            userChoice = menu.getUserChoice();
            if (userChoice == 1)
                list.print();
            if (userChoice == 2)
                list.addNewBook();
            if (userChoice == 3)
                list.saveToFile(fname);
        }
    }
}
