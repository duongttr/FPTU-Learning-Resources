package items;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class NewItems extends Vector<Item> {
    Scanner sc = new Scanner(System.in);
    Vector<String> storedCodes = new Vector<String>();

    public NewItems() {
        super();
    }

    public void loadStoredCodes(String fName) {
        if (storedCodes.size() > 0)
            storedCodes.clear();
        try {
            File f = new File(fName);
            if (!f.exists())
                return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String code, name, priceStr;
            while ((code = bf.readLine()) != null && (name = bf.readLine()) != null
                    && (priceStr = bf.readLine()) != null)
                storedCodes.add(code);
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean valid(String aCode) {
        for (int i = 0; i < storedCodes.size(); i++)
            if (aCode.equals(storedCodes.get(i)))
                return false;
        for (int i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getCode()))
                return false;
        }
        return true;
    }

    private int find(String aCode) {
        for (int i = 0; i < this.size(); i++) {
            if (aCode.equals(this.get(i).getCode()))
                return i;
        }
        return -1;
    }

    public void appendToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f, append);
            PrintWriter pw = new PrintWriter(fw);
            for (Item x : this) {
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }
            pw.close();
            fw.close();
            this.loadStoredCodes(fName);
            this.clear();
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewItem() {
        String newCode, newName;
        int price;
        boolean duplicated = false, matched = true;
        System.out.println("Enter New Item Details:");
        do {
            System.out.print("Code (Format I000): ");
            newCode = sc.nextLine().toUpperCase();
            duplicated = !valid(newCode);
            matched = newCode.matches("^I\\d{3}$");
            if (duplicated)
                System.out.println("The code is duplicated.");
            if (!matched)
                System.out.println("The code: I and 3 digits.");
        } while (duplicated || (!matched));
        System.out.print("Name:  ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("Price:  ");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Item(newCode, newName, price));
        System.out.println("New Item has been added.");
    }

    public void removeItem() {

        if (this.size() == 0) {
            System.out.println("This list is empty!!!");
            return;
        }
        System.out.println("Enter Item code to be removed");
        String newCode;
        boolean existed = false, matched = false;
        do {
            System.out.print("     code(format I000): ");
            newCode = sc.nextLine().toUpperCase();
            if ((newCode.toLowerCase()).equals("c"))
                return;
            existed = find(newCode) > (-1) ? true : false;
            matched = newCode.matches("^I\\d{3}$");
            if (!existed)
                System.out.println("The code is not existed.");
            if (!matched)
                System.out.println("The code: I and 3 digits.");
            System.out.println("Enter \"c\" to cancel!!");
        } while ((!existed) || (!matched));
        this.remove(find(newCode));
        System.out.println("Remove sucessfull!!!");
    }

    public void updatePrice() {
        if (this.size() == 0) {
            System.out.println("This list is empty!!!");
            return;
        }
        System.out.println("Enter Item code to be change");
        String newCode;
        boolean existed = false, matched = false;
        do {
            System.out.print("Code (Format I000): ");
            newCode = sc.nextLine().toUpperCase();
            if ((newCode.toLowerCase()).equals("c"))
                return;
            existed = find(newCode) > (-1) ? true : false;
            matched = newCode.matches("^I\\d{3}$");
            if (!existed)
                System.out.println("The code is not existed.");
            if (!matched)
                System.out.println("The code: I and 3 digits.");
            System.out.println("Enter \"c\" to cancel!!");
        } while ((!existed) || (!matched));
        int newValue = getInt.get(0, "Enter new value: ");
        int pos = find(newCode);
        this.set(pos, new Item(this.get(pos).getCode(), this.get(pos).getName(), newValue));
        System.out.println("Change successfully!!!");
    }

    public void print() {
        System.out.println("-----------------------------");
        System.out.println("Print out the list: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.format("%s|%s|%s\n", this.get(i).getCode(), this.get(i).getName(), this.get(i).getPrice());
        }
        
    }
}
