import java.util.ArrayList;

public class MergeSort {
    ArrayList<Employee> arr = new ArrayList<Employee>();

    public MergeSort(ArrayList<Employee> ls) {
        this.arr.addAll(ls);
    }

    public void sort(boolean asc) {
        if (arr.size() > 1) {
            ArrayList<Employee> left = new ArrayList<Employee>();
            ArrayList<Employee> right = new ArrayList<Employee>();
            int middle = arr.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(arr.get(i));
            }
            for (int i = middle; i < arr.size(); i++) {
                right.add(arr.get(i));
            }
            MergeSort leftSort = new MergeSort(left);
            MergeSort rightSort = new MergeSort(right);
            leftSort.sort(asc);
            rightSort.sort(asc);
            merge(leftSort.arr, rightSort.arr, asc);
        }
    }

    private void merge(ArrayList<Employee> left, ArrayList<Employee> right, boolean asc) {
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((asc ? 1:-1)*left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                arr.set(i, left.get(leftIndex));
                leftIndex++;
            } else {
                arr.set(i, right.get(rightIndex));
                rightIndex++;
            }
            i++;
        }
        ArrayList<Employee> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
        for (int j = restIndex; j < rest.size(); j++) {
            arr.set(i, rest.get(j));
            i++;
        }
    }

    // print arr
    public void print() {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }

}
