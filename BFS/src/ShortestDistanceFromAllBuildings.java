import java.util.LinkedList;
import java.util.Queue;

/**
 * Question :
 *      You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 *      You can only move up, down, left and right.
 *      You are given a 2D grid of values 0, 1 or 2,
 *      where: Each 0 marks an empty land which you can pass by freely.
 *             Each 1 marks a building which you cannot pass through.
 *             Each 2 marks an obstacle which you cannot pass through.
 * Note:
 *      There will be at least one building.
 *      If it is not possible to build such house according to the above rules, return -1
 * @author wyl
 * @create 2021-04-01-14:19
 */
public class ShortestDistanceFromAllBuildings {
    static class Building {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static class Solution {
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

                            for (int k = 0; i < size; i++) {
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
}
