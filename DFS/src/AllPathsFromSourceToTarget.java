import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 797
 * @author yanliu
 * @create 2021-11-07-6:43 PM
 */
public class AllPathsFromSourceToTarget {
    static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();

            if (graph == null || graph.length == 0) {
                return res;
            }

            dfs(graph, 0, new ArrayList<>(), res);

            return res;
        }

        private void dfs(int[][] graph, int start, List<Integer> path, List<List<Integer>> res) {
            path.add(start);

            // arrive to the destination
            if (start == graph.length - 1) {
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }

            for (int v : graph[start]) {
                dfs(graph, v, path, res);
            }

            path.remove(path.size() - 1);
        }
    }
}
