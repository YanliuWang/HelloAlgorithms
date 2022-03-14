/**
 * LeetCode529
 * @author yanliu
 * @create 2022-03-14-3:44 PM
 */
public class Minesweeper {
    static class Solution {
        private int[] dx = new int[]{-1, 0, 0, 1, 1, -1, 1, -1};
        private int[] dy = new int[]{0, 1, -1, 0, -1, 1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {
            int currX = click[0];
            int currY = click[1];

            if (board[currX][currY] == 'M') {
                board[currX][currY] = 'X';

            } else {
                int mines = 0;

                // traverse eight directions
                for (int i = 0; i < 8; i++) {
                    int nextX = currX + dx[i];
                    int nextY = currY + dy[i];

                    if (nextX < 0 || nextX >= board.length
                            || nextY < 0 || nextY >= board[0].length) {
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

                    // traverse eight directions
                    for (int i = 0; i < 8; i++) {
                        int nextX = currX + dx[i];
                        int nextY = currY + dy[i];

                        if (nextX < 0 || nextX >= board.length
                                || nextY < 0 || nextY >= board[0].length) {
                            continue;
                        }

                        if (board[nextX][nextY] == 'E') {
                            updateBoard(board, new int[]{nextX, nextY});
                        }
                    }
                }
            }

            return board;
        }
    }
}
