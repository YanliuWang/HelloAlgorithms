import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode286
 * @author yanliu
 * @create 2022-04-26-9:11 PM
 */
public class WallsAndGates {
    static class Solution {
        private final int EMPTY = Integer.MAX_VALUE;
        private final int GATE = 0;

        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0
                    || rooms[0] == null || rooms[0].length == 0) {
                return;
            }

            Queue<Integer> queue = new LinkedList<>();

            int row = rooms.length;
            int col = rooms[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (rooms[i][j] == GATE) {
                        queue.offer(i * col + j);
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

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col
                            || rooms[nextX][nextY] != EMPTY) {
                        continue;
                    }

                    rooms[nextX][nextY] = rooms[currX][currY] + 1;

                    int next = nextX * col + nextY;
                    queue.offer(next);
                }
            }
        }
    }
}
