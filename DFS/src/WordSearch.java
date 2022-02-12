import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanliu
 * @create 2021-03-25-17:19
 */
public class WordSearch {
    /**
     * LeetCode79
     */
    static class Solution1 {
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

    /**
     * LeetCode212
     */
    static class Solution2 {
        class TrieNode {
            public String word;
            public Map<Character, TrieNode> childrenMap = new HashMap<>();

            public TrieNode() {}
        }

        private int[] dx = new int[]{-1, 0, 0, 1};
        private int[] dy = new int[]{0, -1, 1, 0};

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();

            // construct trie tree
            TrieNode root = new TrieNode();

            for (String word : words) {
                TrieNode curr = root;

                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);

                    if (!curr.childrenMap.containsKey(ch)) {
                        curr.childrenMap.put(ch, new TrieNode());
                    }

                    curr = curr.childrenMap.get(ch);
                }

                curr.word = word;
            }

            // do dfs
            int row = board.length;
            int col = board[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!root.childrenMap.containsKey(board[i][j])) {
                        continue;
                    }

                    dfs(board, i, j, root, res);
                }
            }

            return res;
        }

        private void dfs(char[][] board, int x, int y,
                         TrieNode parent, List<String> res) {
            char letter = board[x][y];
            TrieNode curr = parent.childrenMap.get(letter);

            if (curr.word != null) {
                res.add(curr.word);
                curr.word = null;
            }

            board[x][y] = '#';

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= board.length
                        || nextY < 0 || nextY >= board[0].length) {
                    continue;
                }

                if (curr.childrenMap.containsKey(board[nextX][nextY])) {
                    dfs(board, nextX, nextY, curr, res);
                }
            }

            board[x][y] = letter;

            if (curr.childrenMap.isEmpty()) {
                parent.childrenMap.remove(letter);
            }
        }

    }
}
