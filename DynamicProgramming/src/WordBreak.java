import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode139
 * @author yanliu
 * @create 2021-12-22-6:47 PM
 */
public class WordBreak {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();

            for (String word : wordDict) {
                set.add(word);
            }

            int len = s.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[len];
        }
    }
}
