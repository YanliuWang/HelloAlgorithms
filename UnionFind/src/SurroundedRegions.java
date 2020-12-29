import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2020-12-29-13:51
 */
public class SurroundedRegions {
    static class Solution1 {
        /**
         * using union-find data structure to solve the problem
         * @param board
         */
        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
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
                    if (!uf.isConnected(dummy, i * cols + j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    static class Solution2 {
        /**
         * using recursive dfs to solve the problem
         * @param board
         */
        public void solve(int[][] board) {
            if (board == null || board.length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // search from the edge
                    boolean isEdge = i == 0 || i == rows - 1 || j == 0 || j == cols - 1;

                    if (isEdge && board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; i < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';

                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';

                    }

                }
            }

        }

        private void dfs(int[][] board, int i, int j) {
            int rows = board.length;
            int cols = board[0].length;

            if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '#') {
                return;
            }

            board[i][j] = '#';

            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);

        }
    }

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Solution3 {
        /**
         * using iterative dfs to solve the problem
         * @param board
         */
        public void solve(int[][] board) {
            if (board == null || board.length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // search from the edge
                    boolean isEdge = i == 0 || i == rows - 1 || j == 0 || j == cols - 1;

                    if (isEdge && board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; i < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';

                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';

                    }

                }
            }
        }

        private void dfs(int[][] board, int i, int j) {
            Deque<Pos> stack = new ArrayDeque<>();
            int rows = board.length;
            int cols = board[0].length;

            stack.push(new Pos(i, j));
            board[i][j] = '#';

            while (!stack.isEmpty()) {
                Pos curr = stack.peek();

                if (curr.row - 1 >= 0 && board[curr.row - 1][curr.col] == 'O') {
                    stack.push(new Pos(curr.row - 1, curr.col));
                    board[curr.row - 1][curr.col] = '#';
                    continue;
                }

                if (curr.row + 1 < rows && board[curr.row + 1][cols] == 'O') {
                    stack.push(new Pos(curr.row + 1, curr.col));
                    board[curr.row + 1][curr.col] = '#';
                    continue;
                }

                if (curr.col - 1 >= 0 && board[curr.row][curr.col - 1] == 'O') {
                    stack.push(new Pos(curr.row, curr.col - 1));
                    board[curr.row][curr.col - 1] = '#';
                    continue;
                }

                if (curr.col + 1 < cols && board[curr.row][curr.col + 1] == 'O') {
                    stack.push(new Pos(curr.row, curr.col + 1));
                    board[curr.row][curr.col + 1] = '#';
                    continue;
                }

                stack.pop();
            }
        }
    }

    static class Solution4 {
        public void solve(int[][] board) {
            if (board == null || board.length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // search from the edge
                    boolean isEdge = i == 0 || i == rows - 1 || j == 0 || j == cols - 1;

                    if (isEdge && board[i][j] == 'O') {
                        bfs(board, i, j);
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; i < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';

                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';

                    }

                }
            }
        }

        private void bfs(int[][] board, int i, int j) {
            Queue<Pos> queue = new LinkedList<>();
            int rows = board.length;
            int cols = board[0].length;

            queue.offer(new Pos(i, j));
            board[i][j] = '#';

            while (!queue.isEmpty()) {
                Pos curr = queue.poll();

                if (curr.row - 1 >= 0 && board[curr.row - 1][curr.col] == 'O') {
                    queue.offer(new Pos(curr.row - 1, curr.col));
                    board[curr.row - 1][curr.col] = '#';
                }

                if (curr.row + 1 < rows && board[curr.row + 1][curr.col] == 'O') {
                    queue.offer(new Pos(curr.row + 1, curr.col));
                    board[curr.row + 1][curr.col] = '#';
                }

                if (curr.col - 1 >= 0 && board[curr.row][curr.col - 1] == 'O') {
                    queue.offer(new Pos(curr.row, curr.col - 1));
                    board[curr.row][curr.col - 1] = '#';
                }

                if (curr.col + 1 < cols && board[curr.row][curr.col + 1] == 'O') {
                    queue.offer(new Pos(curr.row, curr.col + 1));
                    board[curr.row][curr.col + 1] = '#';
                }
            }
        }
    }


}
