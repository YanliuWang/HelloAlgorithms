import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC51git
 * @author yanliu
 * @create 2021-01-26-16:40
 */
public class NQueens {
    static class Solution1 {
        private List<List<String>> res = new LinkedList<>();

        public List<List<String>> solveNQueens(int n) {
            if (n <= 0) {
                return res;
            }

            char[][] board = new char[n][n];

            // build the board
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = '.';
                }
            }

            backTrack(board, 0);

            return res;
        }

        private void backTrack(char[][] board, int row) {
            // 结束条件，到达最后一行
            if (row == board.length) {
                res.add(buildToList(board));
                return;
            }

            for (int col = 0; col < board[0].length; col++) {
                // 排除不正确的选择
                if (!isValid(board, row, col)) {
                    continue;
                }

                // 作出选择，放在该行的任意一列
                board[row][col] = 'Q';

                // 进入下一层决策
                backTrack(board, row + 1);

                // 撤销选择
                board[row][col] = '.';
            }
        }

        private List<String> buildToList(char[][] board) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                String str = new String(board[i]);
                list.add(str);
            }

            return list;
        }

        private boolean isValid(char[][] board, int row, int col) {
            // 检查该皇后所在的列的上方是否有冲突
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查该皇后所在的左上角是否有冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查该皇后所在的右上方是否有冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
}
