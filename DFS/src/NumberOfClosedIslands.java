/**
 * LeetCode 1254
 * @author yanliu
 * @create 2021-12-02-10:48 PM
 */
public class NumberOfClosedIslands {
    static class Solution {
        public int closedIsland(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        fill(grid, i, j, row, col);
                    }
                }
            }

            int numOfIslands = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 0) {
                        numOfIslands++;
                        fill(grid, i, j, row, col);
                    }
                }
            }

            return numOfIslands;
        }

        private void fill(int[][] grid, int i, int j, int row, int col) {
            if (i < 0 || i >= row || j < 0 || j >= col) {
                return;
            }

            if (grid[i][j] == 1) {
                return;
            }

            grid[i][j] = 1;

            fill(grid, i + 1, j, row, col);
            fill(grid, i, j + 1, row, col);
            fill(grid, i - 1, j, row, col);
            fill(grid, i, j - 1, row, col);
        }
    }
}
