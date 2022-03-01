/**
 * @author yanliu
 * @create 2022-02-24-4:59 PM
 */

import java.util.Arrays;

/**
 * Given a boolean expression (consist of false 0, true 1, AND &, OR |, XOR ^)
 * and a desired boolean result.
 * Implement a function to figure out that how many parenthetical ways
 * that this expression can return the value of result.
 *
 *
 *
 * Sample 1
 *
 * Input: s = “1 ^ 0 | 0 | 1”, result = 0
 *
 * Output: 2
 *
 * Explanation: 1 ^ (0 | (0 | 1)), 1 ^ ((0 | 0) | 1)
 *
 *
 *
 * Sample 2
 *
 * Input: s = “0 & 0 & 0 & 1 ^ 1 | 0”, result = 1
 *
 * Output: 10
 */
public class BooleanParenthesizationProblem {
    static class Solution {
        public int countParentheticalWays(String s, int result) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int N = s.length();
            // dp[i][j][0] -> the number false parenthetical ways
            // dp[i][j][1] -> the number true parenthetical ways
            int[][][] dp = new int[N + 1][N + 1][2];

            for (int[][] row : dp) {
                for (int[] col : row) {
                    Arrays.fill(col, -1);
                }
            }
            return countParentheticalWays(s, 0, N - 1, result, dp);
        }

        private int countParentheticalWays(String s, int i, int j, int isTrue, int[][][] dp) {
            if (i > j) {
                return 0;
            }

            if (i == j) {
                if (isTrue == 1) {
                    return s.charAt(i) == '1' ? 1 : 0;

                } else {
                    return s.charAt(i) == '0' ? 1 : 0;

                }
            }

            // already calculate the final result
            if (dp[i][j][isTrue] != -1) {
                return dp[i][j][isTrue];
            }

            int ans = 0;
            int leftFalse = 0, leftTrue = 0, rightFalse = 0, rightTrue = 0;

            for (int k = i + 1; k <= j - 1; k += 2) {
                // left side count
                if (dp[i][k - 1][0] != -1) {
                    leftFalse = dp[i][k - 1][0];

                } else {
                    leftFalse = countParentheticalWays(s, i, k - 1, 0, dp);
                }

                if (dp[i][k - 1][1] != -1) {
                    leftTrue = dp[i][k - 1][1];

                } else {
                    leftTrue = countParentheticalWays(s, i, k - 1, 1, dp);

                }

                // right side count
                if (dp[k + 1][j][0] != -1) {
                    rightFalse = dp[k + 1][j][0];

                } else {
                    rightFalse = countParentheticalWays(s, k + 1, j, 0, dp);

                }

                if (dp[k + 1][j][1] != -1) {
                    rightTrue = dp[k + 1][j][1];

                } else {
                    rightTrue = countParentheticalWays(s, k + 1, j, 1, dp);

                }

                char operator = s.charAt(k);

                if (operator == '&') {
                    if (isTrue == 1) {
                        ans = ans + leftTrue * rightTrue;

                    } else {
                        ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;

                    }

                } else if (operator == '|') {
                    if (isTrue == 1) {
                        ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;

                    } else {
                        ans = ans + leftFalse * rightFalse;

                    }

                } else if (operator == '^') {
                    if (isTrue == 1) {
                        ans = ans + leftTrue * rightFalse + leftFalse * rightTrue;

                    } else {
                        ans = ans + leftTrue * rightTrue + leftFalse * rightFalse;

                    }
                }
            }

            dp[i][j][isTrue] = ans;

            return ans;
        }
    }
}
