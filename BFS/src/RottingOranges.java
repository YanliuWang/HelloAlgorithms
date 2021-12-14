import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode994
 * @author yanliu
 * @create 2021-12-12-9:21 PM
 */
public class RottingOranges {
    static class Solution {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            Queue<Integer> queue = new ArrayDeque<>();
            int freshCount = 0;

            // put the rotten oranges to the queue
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == 1) {
                        freshCount++;
                    } else if (grid[r][c] == 2) {
                        queue.offer(r * col + c);
                    }
                }
            }

            if (freshCount == 0) {
                return 0;
            }

            int minitues = 0;
            while (!queue.isEmpty()) {
                minitues++;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    int currX = curr / col;
                    int currY = curr % col;

                    for (int j = 0; j < 4; j++) {
                        int nextX = currX + dx[j];
                        int nextY = currY + dy[j];

                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        if (grid[nextX][nextY] == 0 || grid[nextX][nextY] == 2) {
                            continue;
                        }

                        grid[nextX][nextY] = 2;
                        freshCount--;
                        queue.offer(nextX * col + nextY);

                    }
                }

                if (freshCount == 0) {
                    return minitues;
                }
            }

            return -1;
        }
    }
}
