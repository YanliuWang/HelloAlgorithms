import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode329
 * @author yanliu
 * @create 2022-02-23-5:55 PM
 */
public class LongestIncreasingPathInAMatrix {
    static class Solution1 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        public int longestIncreasingPath(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;

            int res = 1;
            int[][] cache = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res =  Math.max(res, dfs(matrix, i, j, row, col, cache));
                }
            }

            return res;
        }

        private int dfs(int[][] matrix, int x, int y, int row, int col, int[][] cache) {
            if (cache[x][y] != 0) {
                return cache[x][y];
            }

            int res = 1;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col
                        || matrix[nextX][nextY] <= matrix[x][y]) {
                    continue;
                }

                res = Math.max(res, 1 + dfs(matrix, nextX, nextY, row, col, cache));
            }


            cache[x][y] = res;

            return cache[x][y];
        }


    }

    static class Solution2 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, -1, 1, 0};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }

            // construct the directed adjacent graph
            int row = matrix.length, col = matrix[0].length;
            int[][] inDegrees = new int[row][col];

            // calculate the indegree of each node
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = x + dx[dir];
                        int nextY = y + dy[dir];

                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        if (matrix[nextX][nextY] < matrix[x][y]) {
                            inDegrees[x][y]++;
                        }
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();

            // put the 0-indegree node to the queue
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (inDegrees[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }

            int pathSize = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();
                    int currX = curr[0];
                    int currY = curr[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = currX + dx[dir];
                        int nextY = currY + dy[dir];


                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        if (matrix[nextX][nextY] > matrix[currX][currY]) {
                            inDegrees[nextX][nextY]--;

                            if (inDegrees[nextX][nextY] == 0) {
                                queue.offer(new int[]{nextX, nextY});

                            }
                        }
                    }
                }

                pathSize++;
            }

            return pathSize;



        }
    }

    static class Solution3 {
        public int longestIncreasingPath(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;

            // initialize the dp table
            int[][] dp = new int[row][col];
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    dp[x][y] = 1;
                }
            }

            int res = 1;
            boolean updated = false;
            int oldValue = 0;

            while (true) {
                updated = false;

                for (int x = 0; x < row; x++) {
                    for (int y = 0; y < col; y++) {
                        // updated = false;
                        oldValue = dp[x][y];

                        // update the dp table from top to down
                        if (x >= 1 && matrix[x - 1][y] < matrix[x][y]) {
                            dp[x][y] = Math.max(1 + dp[x - 1][y], dp[x][y]);

                        }

                        // update the dp table from left to right
                        if (y >= 1 && matrix[x][y - 1] < matrix[x][y]) {
                            dp[x][y] = Math.max(1 + dp[x][y - 1], dp[x][y]);

                        }

                        if (oldValue != dp[x][y]) {
                            updated = true;
                        }

                        res = Math.max(res, dp[x][y]);
                    }
                }

                for (int x = row - 1; x >= 0; x--) {
                    for (int y = col - 1; y >= 0; y--) {
                        // updated = false;
                        oldValue = dp[x][y];

                        // update the dp table from down to top
                        if (x < row - 1 && matrix[x + 1][y] < matrix[x][y]) {
                            dp[x][y] = Math.max(dp[x][y], 1 + dp[x + 1][y]);

                        }

                        // update the dp table from right to left
                        if (y < col - 1 && matrix[x][y + 1] < matrix[x][y]) {
                            dp[x][y] = Math.max(dp[x][y], 1 + dp[x][y + 1]);

                        }

                        if (oldValue != dp[x][y]) {
                            updated = true;
                        }

                        res = Math.max(res, dp[x][y]);


                    }
                }

                if (!updated) {
                    break;
                }


            }

            return res;


        }
    }
}
