/**
 * SnowFlake OA
 * @author yanliu
 * @create 2022-01-06-2:02 PM
 */

/**
 * Problem: Given a string of characters s, calculate its score using the formula below.
 *          The score of string s is the maximum product of the lengths of two non-overlapping
 *          palindromic subsequences of s that will be referred to as a and b.
 *          In other words, scores(s) = max(length(a)) * max(length(b))
 */
public class PalindromicSequence {
    static class Solution {
        public int maxScore(String s) {
            int n = s.length();

            // calculate the length of palindromic subsequence [i, j]
            int[][] dp = new int[n][n];

            // key : using bottom-up dp way
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;

                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;

                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            int maxProduct = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    maxProduct = Math.max(maxProduct, dp[i][j] * dp[j + 1][n - 1]);
                }
            }

            return maxProduct;
        }
    }
}
