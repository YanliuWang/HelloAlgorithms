/**
 * LeetCode64
 * @author yanliu
 * @create 2021-12-06-10:35 AM
 */
public class MinPathSum {
    static class Solution {
        public int minPathSum(int[][] grid) {
            int[][] memo = new int[grid.length][grid[0].length];

            return dfs(grid, 0, 0, memo);
        }

        private int dfs(int[][] grid, int currRow, int currCol, int[][] memo) {
            if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {
                return grid[currRow][currCol];
            }

            if (currRow < 0 || currRow >= grid.length || currCol < 0 || currCol >= grid[0].length) {
                return Integer.MAX_VALUE;
            }

            if (memo[currRow][currCol] != 0) {
                return memo[currRow][currCol];
            }

            memo[currRow][currCol] = grid[currRow][currCol] + Math.min(dfs(grid, currRow, currCol + 1, memo),
                    dfs(grid, currRow + 1, currCol, memo));
            return memo[currRow][currCol];
        }
    }
}
