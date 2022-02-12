import java.util.Arrays;

/**
 * LeetCode1143
 * @author yanliu
 * @create 2020-10-29-10:23
 */
public class LongestCommonSubsequence {
    static class Solution {
        /**
         * memo is for eliminating duplicate calculation
         */
        private int[][] memo;

        public int longestCommonSubsequence(String s1, String s2) {
            // initialization the dp array
            // including s1 is empty || s2 is empty || s1&s2 are both empty
            memo = new int[s1.length()][s2.length()];

            // -1 means without calculation
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            return dpRecursion(s1, 0, s2, 0);
        }

        // the LCS of s1[i,...] and s2[j,...]
        private int dpRecursion(String s1, int i, String s2, int j) {
            if (i == s1.length() || j == s2.length()) {
                return 0;
            }

            if (memo[i][j] != -1) {
                // i-j is already calculated
                return memo[i][j];
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = 1 + dpRecursion(s1, i+1, s2, j+1);
            } else {
                memo[i][j] = Math.max(dpRecursion(s1, i+1, s2, j),
                        dpRecursion(s1, i, s2, j+1));
            }

            return memo[i][j];
        }

        private int dpIteration(String s1, String s2) {
            int m = s1.length(), n = s2.length();

            // initialization the dp array
            // including s1 is empty || s2 is empty || s1&s2 are both empty
            int[][] dp = new int[m+1][n+1];

            for (int i = 1; i <= m; i++) {
                for (int j= 1; j <= n; j++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            return dp[m][n];

        }
    }

}
