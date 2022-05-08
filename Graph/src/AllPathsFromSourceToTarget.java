import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode797
 * @author yanliu
 * @create 2022-02-26-10:19 AM
 */
public class AllPathsFromSourceToTarget {
   class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();

            dfs(graph, 0, new ArrayList<>(), res);

            return res;

        }

        private void dfs(int[][] graph, int start, List<Integer> path, List<List<Integer>> res) {
            path.add(start);

            int n = graph.length;

            if (start == n - 1) {
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
