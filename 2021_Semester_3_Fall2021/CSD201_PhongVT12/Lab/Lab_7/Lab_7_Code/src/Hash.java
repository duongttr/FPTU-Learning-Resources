import java.util.Hashtable;
import java.util.LinkedList;

public class Hash {
    int m;
    Hashtable < Integer, LinkedList < Student >> hashTable = new Hashtable < Integer, LinkedList < Student >> ();

    public static int hash(String name) {
        int key = (int)(name.charAt(0));
        if (key - 97 >= 0) {
            return key - 97;
        }
        return key - 65;
    }

    public void insert(Student st) {
        int key = Hash.hash(st.name);

        if (hashTable.get(key) == null) {
            LinkedList < Student > tmp = new LinkedList < Student > ();
            tmp.add(st);
            hashTable.put(key, tmp);
            return;
        }
        LinkedList < Student > tmp = (LinkedList < Student > ) hashTable.get(key);
        tmp.add(st);
    }
    public void search(String sname) {
        int key = Hash.hash(sname);
        if (hashTable.get(key) == null) {
            System.out.print("Not exist!");
            return;
        }
        LinkedList < Student > chain = (LinkedList < Student > ) hashTable.get(key);
        for (Student x: chain) {
            if (x.name.equals(sname)) {
                System.out.println(x);
            }
        }
    }

}