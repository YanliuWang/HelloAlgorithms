import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode200
 * @author yanliu
 * @create 2021-10-17-3:41 PM
 */
public class NumberOfIslands {
    class Solution1 {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, -1, 1, 0};
        private final char LAND = '1';
        private final char WATER = '0';
        private final int DIRECTIONS = 4;

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int numOfIslands = 0;
            int row = grid.length, col = grid[0].length;
            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == LAND && !visited[i][j]) {
                        bfs(grid, i, j, row, col, visited);
                        numOfIslands++;
                    }
                }
            }

            return numOfIslands;
        }

        private void bfs(char[][] grid, int x, int y, int row, int col, boolean[][] visited) {
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(x * col + y);
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int currX = curr / col;
                int currY = curr % col;

                for (int i = 0; i < DIRECTIONS; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (!isValid(grid, nextX, nextY, row, col, visited)) {
                        continue;
                    }

                    queue.offer(nextX * col + nextY);
                    visited[nextX][nextY] = true;
                }
            }
        }

        private boolean isValid(char[][] grid, int x, int y, int row, int col, boolean[][] visited) {
            if (x < 0 || x >= row || y < 0 || y >= col) {
                return false;
            }

            if (visited[x][y]) {
                return false;
            }

            return grid[x][y] == LAND;
        }
    }

    class Solution2 {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return 0;
            }

            int islands = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        islands++;
                    }
                }
            }

            return islands;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (grid[x][y] != '1') {
                return;
            }

            grid[x][y] = '*';

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
