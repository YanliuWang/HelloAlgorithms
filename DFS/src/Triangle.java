import java.util.List;

/**
 * LeetCode120
 * @author yanliu
 * @create 2021-12-15-10:42 AM
 */
public class Triangle {
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            Integer[][] memo = new Integer[n][n];

            return dfs(triangle, memo, 0, 0);
        }

        private int dfs(List<List<Integer>> triangle, Integer[][] memo, int i, int j) {
            if (i == triangle.size()) {
                return 0;
            }

            if (memo[i][j] != null) {
                return memo[i][j];
            }

            return memo[i][j] = Math.min(dfs(triangle, memo, i + 1, j), dfs(triangle, memo, i + 1, j + 1)) + triangle.get(i).get(j);
        }
    }
}
