import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> listEmpl = new ArrayList<Employee>();
        listEmpl.add(new Employee("A05", "Tran Quang", 7));
        listEmpl.add(new Employee("A03", "Nguyen An", 7));
        listEmpl.add(new Employee("A01", "Truong Phung ", 5));
        listEmpl.add(new Employee("A04", "Pham Thi Lam", 2));
        listEmpl.add(new Employee("A02", "Do Trung Ton", 5));

        long startTime, endTime;

        System.out.println("\n-----INSERTION SORT-----");
        startTime = System.nanoTime();

        InsertionSort insertionSort = new InsertionSort(listEmpl);
        insertionSort.sort(true);
        insertionSort.print();
        
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\n-----SELECTION SORT-----");
        startTime = System.nanoTime();

        SelectionSort selectionSort = new SelectionSort(listEmpl);
        selectionSort.sort(true);
        selectionSort.print();

        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\n-----BUBBLE SORT-----");
        startTime = System.nanoTime();
        BubbleSort bubbleSort = new BubbleSort(listEmpl);
        bubbleSort.sort(true);
        bubbleSort.print();
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\n-----MERGE SORT-----");
        startTime = System.nanoTime();
        MergeSort mergeSort = new MergeSort(listEmpl);
        mergeSort.sort(true);
        mergeSort.print();

        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\n-----QUICK SORT-----");
        startTime = System.nanoTime();
        QuickSort quickSort = new QuickSort(listEmpl);
        quickSort.sort(true);
        quickSort.print();

        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");

        System.out.println("\n-----HEAP SORT-----");
        startTime = System.nanoTime();
        HeapSort heapSort = new HeapSort(listEmpl);
        heapSort.sort(true);
        heapSort.print();

        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) + " ns");
    }
}
