import java.util.Arrays;

/**
 * LeetCode300
 * @author yanliu
 * @create 2022-04-01-11:28 PM
 */
public class LongestIncreasingSubsequence {
    static class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
}
