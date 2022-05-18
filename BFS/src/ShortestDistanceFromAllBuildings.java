import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode317
 * @author wyl
 * @create 2021-04-01-14:19
 */
public class ShortestDistanceFromAllBuildings {
    class Building {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    class Solution1 {
        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            int xLen = grid.length;
            int yLen = grid.length;

            int[][] distToBuildings = new int[xLen][yLen];
            int[][] reachBuildingsNum = new int[xLen][yLen];

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};

            int buildingsNum = 0;

            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    if (grid[i][j] == 1) {
                        Queue<Building> queue = new LinkedList<>();
                        queue.offer(new Building(i, j));

                        buildingsNum++;
                        int level = 1;

                        boolean[][] visited = new boolean[xLen][yLen];

                        while (!queue.isEmpty()) {
                            int size = queue.size();

                            for (int k = 0; k < size; k++) {
                                Building curr = queue.poll();

                                for (int m = 0; m < 4; m++) {
                                    int nextX = curr.x + dx[m];
                                    int nextY = curr.y + dy[m];

                                    if (nextX >= 0 && nextX < xLen && nextY >= 0 && nextY < yLen
                                            && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                                        distToBuildings[nextX][nextY] += level;
                                        reachBuildingsNum[nextX][nextY]++;

                                        visited[nextX][nextY] = true;
                                        queue.offer(new Building(nextX, nextY));

                                    }
                                }

                            }

                            level++;
                        }
                    }
                }
            }

            int shortest = Integer.MAX_VALUE;

            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    if (grid[i][j] == 0 && reachBuildingsNum[i][j] == buildingsNum) {
                        shortest = Math.min(shortest, distToBuildings[i][j]);
                    }
                }
            }

            return shortest == Integer.MAX_VALUE ? -1 : shortest;
        }

    }

    class Solution2 {
        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, -1, 1, 0};

        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return -1;
            }

            int minDist = Integer.MAX_VALUE;
            int houses = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        houses++;
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        minDist = Math.min(minDist, bfs(i, j, grid, houses));
                    }
                }
            }

            return minDist == Integer.MAX_VALUE ? -1 : minDist;
        }

        private int bfs(int x, int y, int[][] grid, int houses) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            int row = grid.length;
            int col = grid[0].length;
            int start = x * col + y;

            queue.offer(start);
            visited.add(start);

            int dist = 0;
            int searchedHouses = 0;
            int step = 0;

            while (!queue.isEmpty() && searchedHouses != houses) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    int currX = curr / col;
                    int currY = curr % col;

                    if (grid[currX][currY] == 1) {
                        searchedHouses++;
                        dist += step;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = currX + dx[dir];
                        int nextY = currY + dy[dir];

                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        if (visited.contains(nextX * col + nextY)) {
                            continue;
                        }

                        if (grid[nextX][nextY] == 2) {
                            continue;
                        }

                        queue.offer(nextX * col + nextY);
                        visited.add(nextX * col + nextY);
                    }

                }

            }

            if (searchedHouses != houses) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (grid[i][j] == 0 && visited.contains(i * col + j)) {
                            grid[i][j] = 2;
                        }
                    }
                }

                return Integer.MAX_VALUE;
            }

            return dist;
        }

    }
}
