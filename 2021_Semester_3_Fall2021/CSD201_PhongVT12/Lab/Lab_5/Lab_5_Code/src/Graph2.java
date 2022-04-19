import java.util.Arrays;

public class Graph2 {
    int[][] a;
    int n;
    void setAMatrix(int[][] b, int m) {
        this.a = b;
        this.n = m;
    }
    // void Dijkstra(int s) {
    //     int[] d = new int[this.n];
    //     int maxC = 999999999;
    //     Arrays.fill(d, maxC);
    //     d[s] = 0;
    //     boolean[] visited = new boolean[n];
    //     Arrays.fill(visited, false);
    //     while (true) {
    //         int v = -1;
    //         int max_dis = 99999999;
    //         for (int i = 0; i < n; i++) {
    //             if (d[i] < max_dis && visited[i] == false) {
    //                 max_dis = d[i];
    //                 v = i;
    //             }
    //         }
    //         if (v == -1) {
    //             break;
    //         }
    //         visited[v] = true;

    //         for (int u = 0; u < n; u++) {
    //             if (d[u] > d[v] + a[u][v] && a[u][v] > 0) {
    //                 d[u] = d[v] + a[u][v];
    //             }
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         if (d[i] != maxC) {
    //             System.out.println("Distance from " + s + " to " + i + " = " + d[i]);
    //         } else {
    //             System.out.println("There have no path from " + s + " to " + i);
    //         }
    //     }

    // }

    private static String[] labels;
    public void setLabel(String[] c) {
        labels = c;
    }

    private static final int NO_PARENT = -1;

    public void dijkstra(int[][] adjacencyMatrix,
                                        int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;
 
        
        int[] shortestDistances = new int[nVertices];
 
        
        boolean[] added = new boolean[nVertices];
 
        
        for (int vertexIndex = 0; vertexIndex < nVertices;
                                            vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        
        shortestDistances[startVertex] = 0;
 
        
        int[] parents = new int[nVertices];
 
        
        parents[startVertex] = NO_PARENT;
 
        
        for (int i = 1; i < nVertices; i++)
        {
 
            
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] <
                    shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            
            added[nearestVertex] = true;
 
            
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0
                    && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                                                       edgeDistance;
                }
            }
        }
 
        printSolution(startVertex, shortestDistances, parents);
    }

    private void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");
         
        for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                System.out.print("\n" + this.labels[startVertex] + " -> ");
                System.out.print(this.labels[vertexIndex] + " \t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }
 
    private void printPath(int currentVertex,
                                  int[] parents)
    {
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(this.labels[currentVertex] + " ");
    }

}


