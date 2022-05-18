/**
 * LeetCode36
 * @author yanliu
 * @create 2022-05-17-4:27 PM
 */
public class ValidSudoku {
    class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0
                    || board[0] == null || board[0].length == 0) {
                return true;
            }

            int N = board.length;

            int[][] rows = new int[N][N];
            int[][] cols = new int[N][N];
            int[][] boxes = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == '.') {
                        continue;
                    }

                    int pos = board[r][c] - '1';

                    if (rows[r][pos] != 0) {
                        return false;
                    }

                    rows[r][pos]++;

                    if (cols[c][pos] != 0) {
                        return false;
                    }

                    cols[c][pos]++;

                    int box = (r / 3) * 3 + c / 3;

                    if (boxes[box][pos] != 0) {
                        return false;
                    }

                    boxes[box][pos]++;

                }
            }

            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0
                    || board[0] == null || board[0].length == 0) {
                return true;
            }

            int N = board.length;

            int[] rows = new int[N];
            int[] cols = new int[N];
            int[] boxes = new int[N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == '.') {
                        continue;
                    }

                    int pos = board[r][c] - '1';

                    if ((rows[r] & (1 << pos)) > 0) {
                        return false;
                    }

                    rows[r] |= (1 << pos);

                    if ((cols[c] & (1 << pos)) > 0) {
                        return false;
                    }

                    cols[c] |= (1 << pos);

                    int box = (r / 3) * 3 + c / 3;

                    if ((boxes[box] & (1 << pos)) > 0) {
                        return false;
                    }

                    boxes[box] |= (1 << pos);

                }
            }

            return true;
        }
    }
}
