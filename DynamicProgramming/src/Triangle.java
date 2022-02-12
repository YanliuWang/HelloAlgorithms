import java.util.List;

/**
 * LeetCode120
 * @author yanliu
 * @create 2021-12-15-10:46 AM
 */
public class Triangle {
    /**
     * bottom up
     */
    static class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();

            int[][] dp = new int[n + 1][n + 1];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }

            return dp[0][0];
        }
    }

    /**
     * up down
     */
    static class Solution2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);

            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j])
                            + triangle.get(i).get(j);
                }

                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }

            return getMin(dp, n - 1);
        }

        private int getMin(int[][] dp, int row) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < dp[row].length; i++) {
                if (dp[row][i] < min) {
                    min = dp[row][i];
                }
            }

            return min;
        }
    }
}
