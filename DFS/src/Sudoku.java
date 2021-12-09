/**
 * LeetCode37
 * @author yanliu
 * @create 2021-03-28-19:56
 */
public class Sudoku {
    static class Solution {
        public void solveSudoku(char[][] board) {
            int row = board.length;
            int col = board[0].length;

            dfs(board, 0, 0, row, col);
        }

        private boolean dfs(char[][] board, int currRow, int currCol, int row, int col) {
            if (currRow == row) {
                return true;
            }

            if (currCol == col) {
                return dfs(board, currRow + 1, 0, row, col);
            }

            if (board[currRow][currCol] != '.') {
                return dfs(board, currRow, currCol + 1, row, col);
            }

            for (char ch = '1'; ch <= '9'; ch++) {
                if (!isValid(board, currRow, currCol, ch)) {
                    continue;
                }

                board[currRow][currCol] = ch;

                if (dfs(board, currRow, currCol + 1, row, col)) {
                    return true;
                }

                board[currRow][currCol] = '.';
            }

            return false;

        }

        private boolean isValid(char[][] board, int currRow, int currCol, char ch) {
            int rowRegion = currRow / 3;
            int colRegion = currCol / 3;

            for (int i = 0; i < 9; i++) {
                if (board[currRow][i] == ch) {
                    return false;
                }

                if (board[i][currCol] == ch) {
                    return false;
                }

                if (board[rowRegion * 3 + i / 3][colRegion * 3 + i % 3] == ch) {
                    return false;
                }
            }

            return true;
        }
    }
}
