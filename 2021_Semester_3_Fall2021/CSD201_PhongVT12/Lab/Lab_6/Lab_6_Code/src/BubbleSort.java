import java.util.ArrayList;

public class BubbleSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public BubbleSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    public void sort(boolean asc) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if ((asc ? 1:-1)*arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    Employee temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    // print arr
    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
