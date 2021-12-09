/**
 * LeetCode 200
 * @author yanliu
 * @create 2021-12-02-10:18 PM
 */
public class NumberOfIslands {
    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int numOfIslands = 0;
            int row = grid.length, col = grid[0].length;
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(grid, i, j, row, col, visited);
                        numOfIslands++;
                    }
                }
            }

            return numOfIslands;
        }

        private void dfs(char[][] grid, int i, int j, int row, int col, boolean[][] visited) {
            if (i < 0 || i >= row || j < 0 || j >= col) {
                return;
            }

            if (grid[i][j] == '0') {
                return;
            }

            if (visited[i][j]) {
                return;
            }

            visited[i][j] = true;

            dfs(grid, i + 1, j, row, col, visited);
            dfs(grid, i, j + 1, row, col, visited);
            dfs(grid, i - 1, j, row, col, visited);
            dfs(grid, i , j - 1, row, col, visited);

        }
    }
}
