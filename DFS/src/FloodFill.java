/**
 * LeetCode733
 * @author yanliu
 * @create 2022-05-12-3:27 PM
 */
public class FloodFill {
    class Solution {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];

            if (oldColor != newColor) {
                dfs(image, sr, sc, oldColor, newColor);
            }

            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
            if (image[sr][sc] == oldColor) {
                image[sr][sc] = newColor;

                for (int i = 0; i < 4; i++) {
                    int nextX = sr + dx[i];
                    int nextY = sc + dy[i];

                    if (nextX < 0 || nextX >= image.length
                            || nextY < 0 || nextY >= image[0].length) {
                        continue;
                    }

                    dfs(image, nextX, nextY, oldColor, newColor);
                }
            }
        }
    }
}
