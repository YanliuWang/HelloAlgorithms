/**
 * LeetCode72
 * @author yanliu
 * @create 2021-12-14-10:12 PM
 */
public class EditDistance {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 0; i < len1 + 1; i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j < len2 + 1; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i < len1 + 1; i++) {
                for (int j = 1; j < len2 + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];

                    } else {
                        // dp[i - 1][j] <=> delete char[i] from word1 <=> insert char[i] to word2
                        // dp[i - 1][j - 1] <=> replace i with j <=> replace j with i
                        // dp[i][j - 1] <=> insert char[j] to word2 <=> delete
                        dp[i][j] = Math.min(dp[i - 1][j],
                                Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                }
            }

            return dp[len1][len2];
        }
    }
}
