import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {
    public Menu() {
        super();
    }

    public void addMenuItem(String s) {
        this.add(s);
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void show() {
        Object[] option = new Object[this.size()];
        option = this.toArray();
        System.out.print("\n\n\n");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(option[i]);
        }

    }
}
