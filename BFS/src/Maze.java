import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-03-25-14:33
 */
public class Maze {
    static class Solution1 {
        public static boolean solveMaze(char[][] maze, int startX, int startY,
                                        int targetX, int targetY, boolean[][] visited) {
            if (maze == null || maze.length == 0 || maze[0].length == 0) {
                return false;
            }

            int xLen = maze.length;
            int yLen = maze[0].length;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startX * xLen + startY);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int currX = curr / xLen + dx[i];
                    int currY = curr % xLen + dy[i];

                    if (currX == targetX && currY == targetY) {
                        return true;
                    }

                    if (currX >= 0 && currX < xLen
                            && currY >= 0 && currY < yLen
                            && maze[currX][currY] == 'O'
                            && !visited[currX][currY]) {
                        queue.offer(currX * xLen + currY);
                    }
                }
            }

            return false;

        }
    }

    /**
     * LeetCode 490
     */
    static class Solution2 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, -1, 1, 0};

        class Pair {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            Queue<Pair> queue = new LinkedList<>();
            int row = maze.length;
            int col = maze[0].length;
            boolean[][] visited = new boolean[row][col];

            queue.offer(new Pair(start[0], start[1]));
            visited[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                Pair curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = curr.x, y = curr.y;

                    while (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0) {
                        x += dx[i];
                        y += dy[i];
                    }

                    x -= dx[i];
                    y -= dy[i];

                    if (x == destination[0] && y == destination[1]) {
                        return true;
                    }


                    if (!visited[x][y]) {
                        queue.offer(new Pair(x, y));
                        visited[x][y] = true;
                    }
                }
            }

            return false;

        }
    }

    static class Solution3 {
        class Pair {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            int row = maze.length;
            int col = maze[0].length;

            int[][] distance = new int[row][col];
            for (int[] rowArray : distance) {
                Arrays.fill(rowArray, Integer.MAX_VALUE);
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(start[0], start[1]));

            distance[start[0]][start[1]] = 0;

            while (!queue.isEmpty()) {
                Pair curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = curr.x, y = curr.y;
                    int dist = distance[x][y];

                    while (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0) {
                        x += dx[i];
                        y += dy[i];
                        dist++;
                    }

                    x -= dx[i];
                    y -= dy[i];
                    dist--;

                    if (distance[x][y] > dist) {
                        distance[x][y] = dist;
                        queue.offer(new Pair(x, y));
                    }
                }
            }

            int res = distance[destination[0]][destination[1]];

            return res == Integer.MAX_VALUE ? -1 : res;

        }
    }

    /**
     * LeetCode 505
     */
    static class Solution4 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, 1, -1, 0};

        class Pair {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            int row = maze.length;
            int col = maze[0].length;

            int[][] distance = new int[row][col];
            for (int[] rowArray : distance) {
                Arrays.fill(rowArray, Integer.MAX_VALUE);
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(start[0], start[1]));
            distance[start[0]][start[1]] = 0;

            while (!queue.isEmpty()) {
                Pair curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = curr.x + dx[i];
                    int nextY = curr.y + dy[i];
                    int dist = 1;

                    while (nextX >= 0 && nextX < row && nextY >= 0
                            && nextY< col && maze[nextX][nextY] == 0) {
                        nextX += dx[i];
                        nextY += dy[i];
                        dist++;
                    }

                    nextX -= dx[i];
                    nextY -= dy[i];
                    dist--;

                    if (distance[nextX][nextY] > distance[curr.x][curr.y] + dist) {
                        distance[nextX][nextY] = distance[curr.x][curr.y] + dist;
                        queue.offer(new Pair(nextX, nextY));
                    }
                }
            }

            int res = distance[destination[0]][destination[1]];

            return res == Integer.MAX_VALUE ? -1 : res;

        }
    }

    /**
     * LeetCode499
     */
    static class Solution5 {
        class Pair {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, -1, 1, 0};
        private String[] dir = new String[]{"u", "l", "r", "d"};

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            int row = maze.length;
            int col = maze[0].length;

            int[][] distance = new int[row][col];
            for (int[] rowArray : distance) {
                Arrays.fill(rowArray, Integer.MAX_VALUE);
            }

            String[][] path = new String[row][col];
            Queue<Pair> queue = new LinkedList<>();

            queue.offer(new Pair(ball[0], ball[1]));
            distance[ball[0]][ball[1]] = 0;
            path[ball[0]][ball[1]] = "";

            while (!queue.isEmpty()) {
                Pair curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = curr.x, y = curr.y;
                    String currPath = path[x][y];
                    int dist = distance[x][y];

                    while (x >= 0 && x < row && y >= 0 && y < col
                            && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                        x += dx[i];
                        y += dy[i];
                        dist++;
                    }

                    if (x != hole[0] || y != hole[1]) {
                        x -= dx[i];
                        y -= dy[i];
                        dist--;
                    }

                    String newPath = currPath.concat(dir[i]);
                    if (distance[x][y] > dist ||
                            (distance[x][y] == dist && path[x][y].compareTo(newPath) > 0)) {
                        path[x][y] = newPath;
                        distance[x][y] = dist;

                        if (x != hole[0] || y != hole[1]) {
                            queue.offer(new Pair(x, y));
                        }
                    }
                }

            }

            int res = distance[hole[0]][hole[1]];

            return res == Integer.MAX_VALUE ? "impossible" : path[hole[0]][hole[1]];
        }
    }
}
