/**
 * LeetCode 1020
 * @author yanliu
 * @create 2021-12-02-11:08 PM
 */
public class NumberOfEnclaves {
    static class Solution {
        public int numEnclaves(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        fill(grid, i, j, row, col);
                    }
                }
            }

            int res = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        res += 1;
                    }
                }
            }

            return res;
        }

        private void fill(int[][] grid, int i, int j, int row, int col) {
            if (i < 0 || i >= row || j < 0 || j >= col) {
                return;
            }

            if (grid[i][j] == 0) {
                return;
            }

            grid[i][j] = 0;

            fill(grid, i + 1, j, row, col);
            fill(grid, i, j + 1, row, col);
            fill(grid, i - 1, j, row, col);
            fill(grid, i, j - 1, row, col);
        }
    }
}
