

/**
 * @author yanliu
 * @create 2020-12-29-13:51
 */
public class SurroundedRegions {
    static class Solution {
        public void solve(char[][] board) {
            if (board.length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            // leave one number of dummy index
            UnionFind uf = new UnionFind(rows * cols + 1);
            int dummy = rows * cols;

            // union the special 'O' to dummy
            // (x, y) -> x * cols + y
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') {
                    uf.union(dummy, i * cols);
                }

                if (board[i][cols - 1] == 'O') {
                    uf.union(dummy, i * cols + cols - 1);
                }
            }

            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') {
                    uf.union(dummy, j);
                }

                if (board[rows - 1][j] == 'O') {
                    uf.union(dummy, (rows - 1) * cols + j);
                }
            }

            // using four directions array to search
            int[][] d = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};

            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < cols - 1; i++) {
                    if (board[i][j] == 'O') {
                        // connect the 'O' to the 'O' around it
                        for (int k = 0; k < d.length; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];

                            if (board[x][y] == 'O') {
                                uf.union(x * cols + y, i * cols + j);
                            }
                        }
                    }
                }
            }

            for (int i = 1; i < rows - 1; i++) {
                for (int j = 1; j < cols - 1; j++) {
                    if (!uf.connected(dummy, i * cols + j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
