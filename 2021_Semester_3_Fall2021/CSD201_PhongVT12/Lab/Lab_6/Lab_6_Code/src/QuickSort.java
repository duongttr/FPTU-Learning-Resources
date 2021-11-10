import java.util.ArrayList;

public class QuickSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public QuickSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    // sort arr list with quicksort
    public void sort(boolean asc) {
        quickSort(0, arr.size() - 1, asc);
    }

    // quick sort algorithm
    private void quickSort(int low, int high, boolean asc) {
        if (low < high) {
            int pi = partition(low, high, asc);
            quickSort(low, pi - 1, asc);
            quickSort(pi + 1, high, asc);
        }
    }

    // partition the array
    private int partition(int low, int high, boolean asc) {
        Employee pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((asc ? 1:-1)*arr.get(j).compareTo(pivot) < 0) {
                i++;
                Employee temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        Employee temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    // print the sorted array
    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}
