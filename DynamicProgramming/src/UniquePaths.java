/**
 * LeetCode62
 * @author yanliu
 * @create 2022-05-29-10:59 AM
 */
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }

            int[][] grid = new int[m][n];

            for (int c = 0; c < n; c++) {
                grid[0][c] = 1;
            }

            for (int r = 0; r < m; r++) {
                grid[r][0] = 1;
            }

            for (int r = 1; r < m; r++) {
                for (int c = 1; c < n; c++) {
                    grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
                }
            }

            return grid[m - 1][n - 1];
        }
    }
}
