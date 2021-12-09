import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode695
 * @author yanliu
 * @create 2021-12-09-11:24 AM
 */
public class MaxAreaOfIsland {
    static class Solution {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        public int maxAreaOfIsland(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int res = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] != 0) {
                        int[] curr = new int[1];

                        bfs(grid, i, j, curr);

                        res = Math.max(res, curr[0]);
                    }
                }
            }

            return res;
        }

        private void bfs(int[][] grid, int sr, int sc, int[] res) {
            Queue<Integer> queue = new ArrayDeque<>();
            int row = grid.length;
            int col = grid[0].length;

            queue.offer(sr * col + sc);
            grid[sr][sc] = 0;
            res[0]++;

            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                int currRow = curr / col;
                int currCol = curr % col;

                for (int i = 0; i < 4; i++) {
                    int nextRow = currRow + dx[i];
                    int nextCol = currCol + dy[i];

                    if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 0) {
                        continue;
                    }

                    grid[nextRow][nextCol] = 0;
                    queue.offer(nextRow * col + nextCol);
                    res[0]++;
                }
            }
        }
    }
}
