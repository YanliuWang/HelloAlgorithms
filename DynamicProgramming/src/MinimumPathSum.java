/**
 * LeetCode64
 * @author yanliu
 * @create 2021-12-14-6:29 PM
 */
public class MinimumPathSum {
    static class Solution1 {
        public int minPathSum(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int[][] dp = new int[row][col];
            dp[0][0] = grid[0][0];

            for (int r = 1; r < row; r++) {
                dp[r][0] = grid[r][0] + dp[r - 1][0];
            }

            for (int c = 1; c < col; c++) {
                dp[0][c] = grid[0][c] + dp[0][c - 1];
            }

            for (int r = 1; r < row; r++) {
                for (int c = 1; c < col; c++) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }

            return dp[row - 1][col - 1];
        }
    }
}
