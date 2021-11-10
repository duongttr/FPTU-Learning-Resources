import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph1 {
    int[][] a;
    String[] labels;
    int n;
    boolean[] visted_dfs;

    boolean[] visted_bfs;

    void setAMatrix(int[][] b, int m) {
        this.a = b;
        this.n = m;
    }

    void setLabel(String[] c) {
        if (c.length != n) {
            System.out.println("Error: labels.length != n");
            return;
        }
        this.labels = c;
        this.visted_dfs = new boolean[n];
        Arrays.fill(this.visted_dfs, false);
        this.visted_bfs = new boolean[n];
        Arrays.fill(this.visted_bfs, false);

    }

    void bfs(int root) {
        
        Queue < Integer > tranverse_queue = new LinkedList < Integer > ();
        tranverse_queue.add(root);
        visted_bfs[root] = true;
        while (tranverse_queue.isEmpty() == false) {
            int current_node = tranverse_queue.poll();
            System.out.print(this.labels[current_node] + " ");
            for (int i = 0; i < this.n; i++) {
                if (this.a[current_node][i] > 0 && visted_bfs[i] == false) {
                    tranverse_queue.add(i);
                    visted_bfs[i] = true;
                }
            }
        }
    }
    // print bfs from root

    void dfs(int root) {
        System.out.print(this.labels[root] + " ");
        this.visted_dfs[root] = true;
        for (int i = 0; i < this.n; i++) {
            if (a[i][root] > 0 && visted_dfs[i] == false) {
                dfs(i);
            }
        }
    }

}