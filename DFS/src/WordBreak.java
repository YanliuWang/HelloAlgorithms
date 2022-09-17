import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode139
 * @author yanliu
 * @create 2022-09-16-10:13 PM
 */
public class WordBreak {
    static class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return true;
            }

            if (wordDict == null || wordDict.size() == 0) {
                return false;
            }

            Set<String> dict = new HashSet<>(wordDict);

            Boolean[] memo = new Boolean[s.length()];

            return dfs(s, 0, dict, memo);
        }

        private boolean dfs(String s, int index, Set<String> dict, Boolean[] memo) {
            if (index == s.length()) {
                return true;
            }

            if (memo[index] != null) {
                return memo[index];
            }

            for (int end = index + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(index, end)) && dfs(s, end, dict, memo)) {
                    memo[index] = true;
                    return true;
                }
            }

            memo[index] = false;

            return false;
        }
    }
}
