import java.util.Arrays;

/**
 * LeetCode91
 * @author yanliu
 * @create 2022-04-05-5:25 PM
 */
public class DecodeWays {
    /**
     * using top-down dp
     */
    static class Solution1 {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int[] memo = new int[s.length() + 1];
            Arrays.fill(memo, -1);

            return dfs(s, 0, memo);
        }

        private int dfs(String s, int index, int[] memo) {
            if (memo[index] != -1) {
                return memo[index];
            }

            if (index == s.length()) {
                return 1;
            }

            if (s.charAt(index) == '0') {
                return 0;
            }

            if (index == s.length() - 1) {
                return 1;
            }

            int res = dfs(s, index + 1, memo);

            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                res += dfs(s, index + 2, memo);
            }

            memo[index] = res;

            return res;
        }
    }

    /**
     * using bottom-up dp
     */
    static class Solution2 {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int n = s.length();
            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;

            for (int i = 2; i <= n; i++) {
                if (s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 1];
                }

                int two = Integer.parseInt(s.substring(i - 2, i));

                if (two >= 10 && two <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[n];

        }
    }
}
