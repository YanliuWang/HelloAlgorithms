import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-10-17-10:27 AM
 */
public class KnightShortestPath {
    // LintCode611
    class Solution1 {
        // initiate x and y directions
        private final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        private final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        /**
         * @param grid: a chessboard included 0 (false) and 1 (true)
         * @param source: a point
         * @param destination: a point
         * @return: the shortest path
         */
        public int shortestPath(boolean[][] grid, Point source, Point destination) {
            // write your code here
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return -1;
            }

            // create data structure for bfs
            Queue<Point> queue = new LinkedList<>();
            Map<Integer, Integer> distanceToSrc = new HashMap<>();

            // get the row and col
            int row = grid.length;
            int col = grid[0].length;

            // put the source point to the queue
            queue.offer(source);
            distanceToSrc.put(source.x * col + source.y, 0);

            while (!queue.isEmpty()) {
                // poll the current point from queue
                Point curr = queue.poll();

                if (curr.x == destination.x && curr.y == destination.y) {
                    return distanceToSrc.get(curr.x * col + curr.y);
                }

                // move the points arount current point
                for (int i = 0; i < 8; i++) {
                    int nextX = curr.x + dx[i];
                    int nextY = curr.y + dy[i];

                    if (!isValid(grid, nextX, nextY)) {
                        continue;
                    }

                    if (distanceToSrc.containsKey(nextX * col + nextY)) {
                        continue;
                    }

                    queue.offer(new Point(nextX, nextY));
                    distanceToSrc.put(nextX * col + nextY, distanceToSrc.get(curr.x * col + curr.y) + 1);

                }
            }

            return -1;

        }

        private boolean isValid(boolean[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }

            return grid[x][y] == false;
        }
    }

    // LintCode 630
    class Solution2 {
        private final int[] dx = {1, -1, 2, -2};
        private final int[] dy = {2, 2, 1, 1};

        /**
         * @param grid: a chessboard included 0 and 1
         * @return: the shortest path
         */
        public int shortestPath2(boolean[][] grid) {
            // write your code here
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return -1;
            }

            int n = grid.length;
            int m = grid[0].length;

            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> distanceToSrc = new HashMap<>();

            // init source position
            queue.offer(0);
            distanceToSrc.put(0, 0);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int currX = curr / m;
                int currY = curr % m;

                // reach position (n - 1, m - 1)
                if (currX == n - 1 && currY == m - 1) {
                    return distanceToSrc.get(curr);
                }

                // move to the points around the current point
                for (int i = 0; i < 4; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (!isValid(grid, nextX, nextY)) {
                        continue;
                    }

                    if (distanceToSrc.containsKey(nextX * m + nextY)) {
                        continue;
                    }

                    queue.offer(nextX * m + nextY);
                    distanceToSrc.put(nextX * m + nextY, distanceToSrc.get(curr) + 1);
                }
            }

            return -1;
        }

        private boolean isValid(boolean[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }

            return grid[x][y] == false;
        }
    }
}
