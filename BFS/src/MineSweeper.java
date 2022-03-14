import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode529
 * @author yanliu
 * @create 2022-03-14-4:12 PM
 */
public class MineSweeper {
    class Solution {
        private int[] dx = new int[]{-1, 0, 0, 1, 1, -1, -1, 1};
        private int[] dy = new int[]{0, 1, -1, 0, -1, 1, -1, 1};

        public char[][] updateBoard(char[][] board, int[] click) {
            int currX = click[0];
            int currY = click[1];

            if (board[currX][currY] == 'M') {
                board[currX][currY] = 'X';
                return board;
            }

            int row = board.length;
            int col = board[0].length;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(currX * col + currY);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                currX = curr / col;
                currY = curr % col;

                // count the adjacent mines
                int mines = 0;

                for (int i = 0; i < 8; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (nextX < 0 || nextX >= row
                            || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (board[nextX][nextY] == 'M') {
                        mines++;
                    }

                }

                if (mines > 0) {
                    board[currX][currY] = (char) (mines + '0');

                } else {
                    board[currX][currY] = 'B';

                    for (int i = 0; i < 8; i++) {
                        int nextX = currX + dx[i];
                        int nextY = currY + dy[i];

                        if (nextX < 0 || nextX >= row
                                || nextY < 0 || nextY >= col) {
                            continue;
                        }

                        if (board[nextX][nextY] == 'E') {
                            queue.offer(nextX * col + nextY);
                            board[nextX][nextY] = '*';
                        }
                    }

                }
            }

            return board;


        }
    }
}
