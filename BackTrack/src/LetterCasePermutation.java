import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LC784
 * @author yanliu
 * @create 2021-01-30-13:57
 */
public class LetterCasePermutation {
    /**
     * BFS
     */
    static class Solution1 {
        public List<String> letterCasePermutation(String S) {
            if (S == null || S.length() == 0) {
                return new LinkedList<>();
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(S);

            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i))) {
                    continue;
                }

                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    String curr = queue.poll();
                    char[] currArray = curr.toCharArray();

                    currArray[i] = Character.toUpperCase(currArray[i]);
                    queue.offer(String.valueOf(currArray));

                    currArray[i] = Character.toLowerCase(currArray[i]);
                    queue.offer(String.valueOf(currArray));
                }
            }

            return new LinkedList<>(queue);
        }
    }

    /**
     * DFS
     */
    static class Solution2 {
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
            if (S == null || S.length() == 0) {
                return new LinkedList<>();
            }

            dfs(S.toCharArray(), 0);

            return res;
        }

        private void dfs(char[] currArray, int start) {
            if (start == currArray.length) {
                res.add(String.valueOf(currArray));
            }

            dfs(currArray, start + 1);

            if (Character.isDigit(currArray[start])) {
                return;
            }

            // 大小写转换
            currArray[start] ^= 1 << 5;
            dfs(currArray, start + 1);

            // 回退大小写转换
            currArray[start] ^= 1 << 5;
        }
    }
}
