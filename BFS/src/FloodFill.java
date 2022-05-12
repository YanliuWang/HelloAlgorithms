import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode733
 * @author yanliu
 * @create 2022-05-12-3:20 PM
 */
public class FloodFill {
    class Solution {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int row = image.length;
            int col = image[0].length;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(sr * col + sc);

            int sameColor = image[sr][sc];

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int currX = curr / col;
                int currY = curr % col;

                image[currX][currY] = newColor;

                for (int i = 0; i < 4; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (nextX < 0 || nextX >= row
                            || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (image[nextX][nextY] != sameColor
                            || image[nextX][nextY] == newColor) {
                        continue;
                    }

                    queue.offer(nextX * col + nextY);
                }
            }

            return image;
        }
    }
}
