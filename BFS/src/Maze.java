import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-03-25-14:33
 */
public class Maze {
    static class Solution {
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
}
