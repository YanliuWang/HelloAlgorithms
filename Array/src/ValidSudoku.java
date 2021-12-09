/**
 * LeetCode36
 * @author yanliu
 * @create 2021-12-09-12:02 PM
 */
public class ValidSudoku {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] area = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char ch = board[i][j];

                    if (ch == '.') {
                        continue;
                    }

                    // zero-based index
                    int index = ch - '0' - 1;
                    int areaIndex = i / 3 * 3 + j / 3;

                    if (row[i][index] || col[j][index]
                            || area[areaIndex][index]) {
                        return false;
                    }

                    row[i][index] = true;
                    col[j][index] = true;
                    area[areaIndex][index] = true;
                }
            }

            return true;
        }
    }
}
