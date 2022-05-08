/**
 * LeetCode785
 * @author yanliu
 * @create 2022-05-07-5:34 PM
 */
public class IsGraphBipartite {
    class Solution1 {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;

            boolean[] colors = new boolean[n];
            boolean[] visited = new boolean[n];

            for (int v = 0; v < n; v++) {
                if (!visited[v] && !dfs(v, graph, colors, visited)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(int v, int[][] graph, boolean[] colors, boolean[] visited) {
            visited[v] = true;

            for (int w : graph[v]) {
                if (visited[w]) {
                    if (colors[w] == colors[v]) {
                        return false;

                    }

                    continue;
                }

                colors[w] = !colors[v];

                if (!dfs(w, graph, colors, visited)) {
                    return false;
                }
            }

            return true;
        }
    }


    class Solution2 {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;

            int[] colors = new int[n];

            for (int i = 0; i < n; i++) {
                if (colors[i] == 0 && !dfs(i, 1, colors, graph)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(int v, int color, int[] colors, int[][] graph) {
            colors[v] = color;

            for (int w : graph[v]) {
                if (colors[w] == 0) {
                    colors[w] = -color;

                    if (!dfs(w, -color, colors, graph)) {
                        return false;
                    }

                } else {
                    if (colors[w] == colors[v]) {
                        return false;

                    }
                }
            }

            return true;
        }
    }

}
