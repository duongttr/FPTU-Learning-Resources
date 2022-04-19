import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Depth First Search and Breath First Search: ");
        Graph1 gr = new Graph1();
        int[][] b = readAMatrix();
        int m = 9;
        String[] labels = {
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i"
        };
        gr.setAMatrix(b, m);
        gr.setLabel(labels);
        System.out.print("DFS: ");
        gr.dfs(0);
        System.out.println();
        System.out.print("BFS: ");
        gr.bfs(0);
        System.out.println();
        System.out.println();


        System.out.println("Dijkstra Algorithms: ");
        Graph2 gr2 = new Graph2();
        gr2.setLabel((labels));
        int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        gr2.dijkstra(adjacencyMatrix, 5);
        System.out.println();

        int[][] connected_tree = readConnectedTree();

        Graph3 gr3 = new Graph3();
        gr3.setAMatrix(connected_tree, connected_tree.length);
        gr3.prim();
    }

    // write a function that read 2d array from matrix.txt
    // and return a 2d array
    public static int[][] readAMatrix() throws Exception {
        int[][] matrix = new int[9][9];
        File file = new File("matrix.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            for (int j = 0; j < str.length; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
            i++;
        }
        return matrix;
    }

    // write a function that read 2d array from tree.txt
    // and return a 2d array
    public static int[][] readConnectedTree() throws Exception {
        int[][] matrix = new int[7][7];
        File file = new File("tree.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            for (int j = 0; j < str.length; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
            i++;
        }
        return matrix;
    }
}