import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode323
 * @author yanliu
 * @create 2022-03-07-2:57 PM
 */
public class NumberConnectedComponentsInUndirectedGraph {
    static class Solution {
        public int countComponents(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            boolean[] isVisited = new boolean[n];

            // initialize
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // construct the graph
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    res++;
                    dfs(i, graph, isVisited);
                }
            }

            return res;
        }

        private void dfs(int start, List<List<Integer>> graph, boolean[] isVisited) {
            isVisited[start] = true;

            for (int next : graph.get(start)) {
                if  (!isVisited[next]) {
                    dfs(next, graph, isVisited);

                }
            }
        }
    }
}
