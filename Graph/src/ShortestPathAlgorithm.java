import java.util.ArrayList;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-10-27-11:25 PM
 */
public class ShortestPathAlgorithm {
    /**
     * Dijkstra's algorithm for adjacent matrix
     */
    static class Solution1 {
        /**
         * print the shortest distance from src to each vertex
         * @param graph
         * @param src
         * @param vertices
         */
        public static void dijkstra(int[][] graph, int src, int vertices) {
            if (graph == null || graph.length == 0
                    || graph[0] == null || graph[0].length == 0) {
                return;
            }

            // the shortest distance from src to each vertex
            int[] shortestPath = new int[vertices];
            // whether a vertex is included in the shortest distance set
            boolean[] shortestPathSet = new boolean[vertices];

            for (int v = 0; v < vertices; v++) {
                shortestPath[v] = Integer.MAX_VALUE;
                shortestPathSet[v] = false;
            }

            // start from source
            shortestPath[src] = 0;

            for (int count = 0; count < vertices - 1; count++) {
                // get the index of the minimum distance vertex from the unprocessed vertices
                int u = minDistance(shortestPath, shortestPathSet, vertices);

                shortestPathSet[u] = true;

                // update the shortest for the adjacent of the vertex
                for (int v = 0; v < vertices; v++) {
                    if (!shortestPathSet[v] && graph[u][v] != 0 && shortestPath[u] != Integer.MAX_VALUE &&
                            shortestPath[u] != Integer.MAX_VALUE && shortestPath[v] > shortestPath[u] + graph[u][v]) {
                        shortestPath[v] = shortestPath[u] + graph[u][v];
                    }
                }
            }

            printSolution(shortestPath);
        }

        /**
         * return the min index of unprocessed vertex
         * @param dist : store the shortest distance from i to  src
         * @param vertices number of vertices
         * @param sptSet shortest path
         * @return
         */
        private static int minDistance(int[] dist, boolean[] sptSet, int vertices) {
            int minIdx = -1;
            int min = Integer.MAX_VALUE;

            for (int v = 0; v < vertices; v++) {
                if (!sptSet[v] && dist[v] <= min) {
                    minIdx = v;
                    min = dist[v];
                }
            }

            return minIdx;
        }

        private static void printSolution(int[] dist) {
            for (int i = 0; i < dist.length; i++) {
                System.out.println("the shortest distance src -> " + i + " is: " + dist[i]);
            }
        }

        public static void main(String[] args) {
            /* Let us create the example graph discussed above */
            int graph[][] = new int[][] {
                    { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
            };

            dijkstra(graph, 0, 9);
        }

    }
}
