import java.util.ArrayList;

public class HeapSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public HeapSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    public void sort(boolean asc) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, asc);
        }
        for (int i = n - 1; i >= 0; i--) {
            Employee temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0, asc);
        }
    }

    public void heapify(ArrayList<Employee> arr, int n, int i, boolean asc) {
        
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int curr = i;
            if (l < n && (asc ? 1:-1)*arr.get(l).compareTo(arr.get(curr)) > 0) {
                curr = l;
            }
            if (r < n && (asc ? 1:-1)*arr.get(r).compareTo(arr.get(curr)) > 0) {
                curr = r;
            }
            if (curr != i) {
                Employee temp = arr.get(i);
                arr.set(i, arr.get(curr));
                arr.set(curr, temp);
                heapify(arr, n, curr, asc);
            }
    }

    // print all employees

    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
