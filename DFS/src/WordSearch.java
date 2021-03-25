/**
 * LC79
 * @author yanliu
 * @create 2021-03-25-17:19
 */
public class WordSearch {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }

            boolean[][] visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(i, j, board, word, 0, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean exist(int x, int y, char[][] board, String word, int start, boolean[][] visited) {
            if (start == word.length()) {
                return true;
            }

            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                    || visited[x][y] || board[x][y] != word.charAt(start)) {
                return false;
            }

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                if (exist(x + dx[i], y + dy[i], board, word, start + 1, visited)) {
                    return true;
                }
            }

            visited[x][y] = false;

            return false;
        }
    }
}
