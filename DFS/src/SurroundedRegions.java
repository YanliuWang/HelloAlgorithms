/**
 * @author yanliu
 * @create 2021-11-15-5:48 PM
 */
public class SurroundedRegions {
    static class Solution {
        private int[] dx = new int[]{-1, 0, 1, 0};
        private int[] dy = new int[]{0, -1, 0, 1};

        public void solve(char[][] board) {
            if (board == null || board.length == 0
                    || board[0] == null || board[0].length == 0) {
                return;
            }

            int row = board.length;
            int col = board[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    boolean isEdge = i == 0 || i == row - 1
                            || j == 0 || j == col - 1;

                    if (isEdge && board[i][j] == 'O') {
                        // flip the 'O' connect to the edge 'O' to '#'
                        dfs(board, i, j, row, col);
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }

        }

        private void dfs(char[][] board, int x, int y, int row, int col) {
            board[x][y] = '#';

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // out of boundary
                if (!isValid(nextX, nextY, row, col, board)) {
                    continue;
                }

                // is visited before
                if (board[nextX][nextY] == '#') {
                    continue;
                }

                dfs(board, nextX, nextY, row, col);
            }
        }

        private boolean isValid(int x, int y, int row, int col, char[][] board) {
            if (x < 0 || x >= row || y < 0 || y >= col) {
                return false;
            }

            return board[x][y] == 'O';
        }
    }
}
