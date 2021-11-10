import java.util.ArrayList;

public class SelectionSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public SelectionSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    public void sort(boolean asc) {
        for (int i = 0; i < arr.size(); i++) {
            int m = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if ((asc ? 1:-1)*arr.get(j).compareTo(arr.get(m)) < 0) {
                    m = j;
                }
            }
            Employee temp = arr.get(i);
            arr.set(i, arr.get(m));
            arr.set(m, temp);
        }
    }

    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
