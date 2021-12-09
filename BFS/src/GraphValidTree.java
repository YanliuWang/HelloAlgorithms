import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 261
 * @author yanliu
 * @create 2021-11-17-5:15 PM
 */
public class GraphValidTree {
    static class Solution {
        public boolean validTree(int n, int[][] edges) {
            if (n - 1 != edges.length) {
                return false;
            }

            // construct the graph
            int[][] graph = new int[n][n];
            for (int[] edge : edges) {
                graph[edge[0]][edge[1]] = 1;
                graph[edge[1]][edge[0]] = 1;
            }

            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(0);
            visited[0] = true;

            while (!queue.isEmpty()) {
                Integer curr = queue.poll();

                for (int i = 0; i < n; i++) {
                    if (graph[curr][i] == 1) {
                        if (visited[i]) {
                            return false;
                        }

                        queue.offer(i);
                        visited[i] = true;
                        graph[curr][i] = 0;
                        graph[i][curr] = 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }

            return true;

        }
    }
}
