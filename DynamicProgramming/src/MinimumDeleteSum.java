/**
 * @author yanliu
 * @create 2020-10-28-18:11
 */
public class MinimumDeleteSum {
    static class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            return dpIteration(s1, 0, s2, 0);

        }

        private int dpIteration(String s1, int i, String s2, int j) {
            int m = s1.length(), n = s2.length();

            int[][] dp = new int[m+1][n+1];

            // if s2 is empty
            for (i = 1; i <= m; i++) {
                dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
            }

            // if s1 is empty
            for (j = 1; j <= n; j++) {
                dp[0][j] = s2.charAt(j-1) + dp[0][j-1];
            }

            // if s1 is not empty and s2 is not empty
            for (i = 1; i <= m; i++) {
                for (j = 1; j <= n; j++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j],
                                s2.charAt(j-1) + dp[i][j-1]);
                    }
                }
            }

            return dp[m][n];
        }
    }
}
