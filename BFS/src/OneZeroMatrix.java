import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode542
 * @author yanliu
 * @create 2021-12-13-8:42 PM
 */
public class OneZeroMatrix {
    /**
     * using bfs to solve the problem
     */
    static class Solution1 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        public int[][] updateMatrix(int[][] mat) {
            int row = mat.length;
            int col = mat[0].length;

            boolean[][] visited = new boolean[row][col];
            Queue<Integer> queue = new ArrayDeque<>();


            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (mat[r][c] == 0) {
                        queue.offer(r * col + c);
                        visited[r][c] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int currX = curr / col;
                int currY = curr % col;

                for (int i = 0; i < 4; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (nextX < 0 || nextX >= row || nextY < 0
                            || nextY >= col || visited[nextX][nextY]) {
                        continue;
                    }

                    mat[nextX][nextY] = mat[currX][currY] + 1;
                    visited[nextX][nextY] = true;
                    queue.offer(nextX * col + nextY);
                }
            }

            return mat;
        }
    }

    /**
     * using dp to solve the problem
     */
    static class Solution2 {
        public int[][] updateMatrix(int[][] mat) {
            int row = mat.length;
            int col = mat[0].length;
            int INF = Integer.MAX_VALUE - 1;

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (mat[r][c] != 0) {
                        mat[r][c] = INF;
                    }
                }
            }

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (mat[r][c] == 0) {
                        continue;
                    }

                    if (r - 1 >= 0) {
                        mat[r][c] = Math.min(mat[r][c], mat[r - 1][c] + 1);
                    }

                    if (c - 1 >= 0) {
                        mat[r][c] = Math.min(mat[r][c], mat[r][c - 1] + 1);
                    }
                }
            }

            for (int r = row - 1; r >= 0; r--) {
                for (int c = col - 1; c >= 0; c--) {
                    if (mat[r][c] == 0) {
                        continue;
                    }

                    if (r + 1 < row) {
                        mat[r][c] = Math.min(mat[r][c], mat[r + 1][c] + 1);
                    }

                    if (c + 1 < col) {
                        mat[r][c] = Math.min(mat[r][c], mat[r][c + 1] + 1);
                    }
                }
            }

            return mat;
        }
    }
}
