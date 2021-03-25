/**
 * @author yanliu
 * @create 2021-03-14-15:52
 */
public class Maze {
    /**
     * Given a maze and a start point and a target point
     * return whether the target can be reached
     */
    static class Solution1 {
        private boolean solveMaze(char[][] maze, int startX, int startY,
                                  int targetX, int targetY, boolean[][] visited) {
            if (startX < 0 || startX >= maze.length || startY < 0 || startY >= maze[0].length
                    || maze[startX][startY] == 'X'
                    || visited[startX][startY]) {
                return false;
            }

            if (startX == targetX && startY == targetY) {
                return true;
            }

            visited[startX][startY] = true;

            if (solveMaze(maze, startX + 1, startY, targetX, targetY, visited)
                    || solveMaze(maze, startX, startY + 1, targetX, targetY, visited)
                    || solveMaze(maze, startX - 1, startY, targetX, targetY, visited)
                    || solveMaze(maze, startX, startY - 1, targetX, targetY, visited)) {
                return true;
            }

            return false;


        }
    }

    /**
     * not using visited[]
     */
    static class Solution2 {
        private boolean solveMaze(char[][] maze, int startX, int startY, int targetX, int targetY) {
            if (startX < 0 || startX >= maze.length || startY < 0 || startY >= maze[0].length
                    || maze[startX][startY] == 'X') {
                return false;
            }

            if (startX == targetX && startY == targetY) {
                return true;
            }

            maze[startX][startY] = 'X';

            if (solveMaze(maze, startX + 1, startY, targetX, targetY)
                    || solveMaze(maze, startX, startY + 1, targetX, targetY)
                    || solveMaze(maze, startX - 1, startY, targetX, targetY)
                    || solveMaze(maze, startX, startY - 1, targetX, targetY)) {
                return true;
            }

            return false;
        }
    }





}
