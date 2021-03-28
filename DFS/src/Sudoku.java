/**
 * LC37
 * @author yanliu
 * @create 2021-03-28-19:56
 */
public class Sudoku {
    static class Solution {
        private boolean[][] rowUsed = new boolean[9][10];
        private boolean[][] colUsed = new boolean[9][10];
        private boolean[][] boxUsed = new boolean[9][10];

        public void solveSudoku(char[][] board) {
            if (board == null || board.length != 9 || board[0].length != 9) {
                return;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    char ch = board[i][j];

                    if (ch =='.') {
                        continue;
                    }

                    int num = ch - '0';
                    int row = i / 3;
                    int col = j / 3;

                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[row * 3 + col][num] = true;

                }
            }

            fillBoard(board, 0, 0);

        }

        private boolean fillBoard(char[][] board, int row, int col) {
            if (col == board[0].length) {
                // get the next coordinate
                col = 0;
                row++;

                if (row == board.length) {
                    return true;
                }
            }

            if (board[row][col] != '.') {
                return fillBoard(board, row, col + 1);

            } else {
                for (int num = 1; num <= 9; num++) {
                    int boxRow = row / 3;
                    int boxCol = col / 3;

                    if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[boxRow * 3 + boxCol][num]) {
                        rowUsed[row][num] = true;
                        colUsed[col][num] = true;
                        boxUsed[boxRow * 3 + boxCol][num] = true;

                        board[row][col] = (char)(num + '0');

                        if (fillBoard(board, row, col + 1)) {
                            return true;
                        }

                        rowUsed[row][num] = false;
                        colUsed[col][num] = false;
                        boxUsed[boxRow * 3 + boxCol][num] = false;

                        board[row][col] = '.';
                    }
                }
            }

            return false;
        }


    }
}
