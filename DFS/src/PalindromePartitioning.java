import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode131
 * @author yanliu
 * @create 2021-01-30-11:55
 */
public class PalindromePartitioning {
    static class Solution1 {
        private List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.length() == 0) {
                return res;
            }

            List<String> tmp = new ArrayList<>();

            backTrack(tmp, s, 0);

            return res;
        }

        private void backTrack(List<String> tmp, String s, int start) {
            if (start == s.length()) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }

                tmp.add(s.substring(start, i + 1));

                backTrack(tmp, s, i + 1);

                tmp.remove(tmp.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }

            return true;
        }
    }

    static class Solution2 {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();

            boolean[][] isPalindrome = getPalindrome(s);

            dfs(s, 0, new ArrayList<>(), res, isPalindrome);

            return res;

        }

        private void dfs(String s, int start, List<String> curr,
                         List<List<String>> res, boolean[][] isPalindrome) {
            if (start == s.length()) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome[start][i]) {
                    continue;
                }

                curr.add(s.substring(start, i + 1));

                dfs(s, i + 1, curr, res, isPalindrome);

                curr.remove(curr.size() - 1);

            }
        }

        private boolean[][] getPalindrome(String s) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
            }

            for (int i = 0; i < n - 1; i++) {
                isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }

            for (int i = n - 3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1]
                            && s.charAt(i) == s.charAt(j);
                }
            }

            return isPalindrome;
        }
    }
}
