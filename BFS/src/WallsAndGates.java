import java.util.*;

/**
 * LeetCode286
 * @author yanliu
 * @create 2022-04-26-9:11 PM
 */
public class WallsAndGates {
    static class Solution1 {
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

    static class Solution2 {
        private final int DIR = 4;
        private final int[] dx = {-1, 0, 0, 1};
        private final int[] dy = {0, 1, -1, 0};

        /**
         * @param rooms: m x n 2D grid
         * @return: nothing
         */
        public void wallsAndGates(int[][] rooms) {
            // write your code here
            if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
                return;
            }

            int row = rooms.length;
            int col = rooms[0].length;

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (rooms[r][c] != 0) {
                        continue;
                    }

                    bfs(rooms, r, c);
                }
            }

        }

        private void bfs(int[][] rooms, int startRow, int startCol) {
            Map<Integer, Integer> distanceToGate = new HashMap<>();
            int row = rooms.length;
            int col = rooms[0].length;
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(startRow * col + startCol);
            distanceToGate.put(startRow * col + startCol, 0);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int currX = curr / col;
                int currY = curr % col;

                for (int i = 0; i < DIR; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (rooms[nextX][nextY] == 0 || rooms[nextX][nextY] == -1) {
                        continue;
                    }

                    if (distanceToGate.containsKey(nextX * col + nextY)) {
                        continue;
                    }

                    queue.offer(nextX * col + nextY);
                    distanceToGate.put(nextX * col + nextY, distanceToGate.get(curr) + 1);

                    if (rooms[nextX][nextY] > distanceToGate.get(nextX * col + nextY)) {
                        rooms[nextX][nextY] = distanceToGate.get(nextX * col + nextY);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[][] rooms = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};

        solution2.wallsAndGates(rooms);


    }
}
