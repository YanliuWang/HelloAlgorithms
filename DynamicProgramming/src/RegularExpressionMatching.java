/**
 * LeetCode 10
 * @author yanliu
 * @create 2021-12-02-5:37 PM
 */
public class RegularExpressionMatching {
    static class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();

            // 1.state
            boolean[][] dp = new boolean[sLen + 1][pLen + 1];

            // 2.init
            // 2.1 s and p are both empty
            dp[0][0] = true;
            // 2.2 s is not empty and p is empty -> dp[i][0] = false;
            // 2.3 s is empty and p is not empth
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            // 3.function
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];

                    } else if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            // p before * is matched
                            // use zero time before *
                            // use one time before *
                            // use two times before *
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];

                        } else {
                            // p before * is not matched
                            // use zero time before *
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }

            return dp[sLen][pLen];

        }
    }
}
