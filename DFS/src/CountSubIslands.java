/**
 * LeetCode 1905
 * @author yanliu
 * @create 2021-12-03-1:14 PM
 */
public class CountSubIslands {
    class Solution1 {
        private int[] dx = new int[]{-1, 0, 1, 0};
        private int[] dy = new int[]{0, 1, 0, -1};

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int row = grid2.length;
            int col = grid2[0].length;

            int res = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid2[i][j] == 1 && isSubIslands(grid1, grid2, i, j, row, col)) {
                        res++;
                    }
                }
            }

            return res;
        }

        private boolean isSubIslands(int[][] grid1, int[][] grid2, int i, int j, int row, int col) {
            boolean flag = true;
            grid2[i][j] = 0;

            if (grid1[i][j] == 0) {
                flag = false;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextX = i + dx[dir];
                int nextY = j + dy[dir];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid2[nextX][nextY] == 1) {
                    if (!isSubIslands(grid1, grid2, nextX, nextY, row, col)) {
                        flag = false;
                    }
                }
            }

            return flag;
        }
    }

    class Solution2 {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid1.length;
            int n = grid1[0].length;
            int res = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                        dfs(grid2, i, j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        dfs(grid2, i, j);
                        res++;
                    }
                }
            }

            return res;
        }

        private void dfs(int[][] grid, int x, int y) {
            if (grid[x][y] != 1) {
                return;
            }

            grid[x][y] = 0;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= grid.length
                        || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }

                dfs(grid, nextX, nextY);
            }
        }
    }
}
