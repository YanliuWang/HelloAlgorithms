import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-01-30-11:55
 */
public class PalindromePartitioning {
    /**
     * LC131
     */
    static class Solution {
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
}
