/**
 * LeetCode 695
 * @author yanliu
 * @create 2021-12-03-10:01 AM
 */
public class MaxAreaOfIsland {
    static class Solution {
        private int[] dx = new int[]{-1, 0, 1, 0};
        private int[] dy = new int[]{0, 1, 0, -1};

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int row = grid.length;
            int col = grid[0].length;

            int max = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        int[] area = new int[1];
                        dfs(grid, i, j, row, col, area);

                        max = Math.max(max, area[0]);
                    }
                }
            }

            return max;
        }

        private void dfs(int[][] grid, int i, int j, int row, int col, int[] area) {
            if (i < 0 || i >= row || j < 0 || j >= col) {
                return;
            }

            if (grid[i][j] == 0) {
                return;
            }

            grid[i][j] = 0;
            area[0]++;

            for (int direction = 0; direction < 4; direction++) {
                dfs(grid, i + dx[direction], j + dy[direction], row, col, area);
            }


        }
    }
}
