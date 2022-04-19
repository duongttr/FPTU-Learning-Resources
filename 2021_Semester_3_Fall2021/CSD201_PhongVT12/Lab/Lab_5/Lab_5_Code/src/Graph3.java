import java.util.ArrayList;

public class Graph3 {
    int[][] a;
    int n;
    void setAMatrix(int[][] b, int m) {
        this.a = b;
        this.n = m;
    }
    void prim() {
        int root = 0;
        int spaning_tree_cost = 0;
        int maxC = 99999999;
        ArrayList < Integer > visited = new ArrayList < Integer > ();
        visited.add(root);
        while (true) {
            int v = -1;
            int min_dis = maxC;
            for (int x: visited) {
                for (int i = 0; i < n; i++) {
                    if (visited.contains(i) == false) {
                        if (a[i][x] < min_dis && a[i][x] > 0) {
                            v = i;
                            min_dis = a[i][x];
                        }
                    }
                }
            }
            if (v == -1) {
                break;
            }
            visited.add(v);
            spaning_tree_cost += min_dis;
        }
        System.out.println("Minimum Spaning Tree cost= " + spaning_tree_cost);
    }
    // write a method to read the 2d array in matrix.txt

    public int[][] readMatrix() {
        int[][] matrix = new int[10][10];
        int i = 0;
        int j = 0;
        try {
            java.io.File file = new java.io.File("matrix.txt");
            java.io.FileReader fileReader = new java.io.FileReader(file);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (int k = 0; k < numbers.length; k++) {
                    matrix[i][j] = Integer.parseInt(numbers[k]);
                    j++;
                }
                i++;
                j = 0;
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        return matrix;

    }
}