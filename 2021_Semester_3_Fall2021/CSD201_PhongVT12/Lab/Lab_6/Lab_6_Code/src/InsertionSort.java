import java.util.ArrayList;

public class InsertionSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public InsertionSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    // sort arr with insertion sort
    public void sort(boolean asc) {
        for (int i = 1; i < arr.size(); i++) {
            Employee key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && (asc ? 1:-1)*arr.get(j).compareTo(key) > 0) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }

    // print sorted array
    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
