import java.util.Arrays;

/**
 * @author yanliu
 * @create 2022-01-16-3:24 PM
 */
public class JumpGameII {
    static class Solution1 {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);

            return solve(nums, dp, 0);
        }

        private int solve(int[] nums, int[] dp, int start) {
            if (start >= nums.length - 1) {
                return 0;
            }

            if (dp[start] != Integer.MAX_VALUE - 1) {
                return dp[start];
            }

            for (int i = 1; i <= nums[start]; i++) {
                dp[start] = Math.min(dp[start],
                        1 + solve(nums, dp, start + i));

            }

            return dp[start];
        }

    }


    static class Solution2 {
        private final int MAX_STEP = Integer.MAX_VALUE - 1;

        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            Arrays.fill(dp, MAX_STEP);
            dp[n - 1] = 0;

            for (int start = n - 2; start >= 0; start--) {
                for (int jumpLen = 1; jumpLen <= nums[start]; jumpLen++) {
                    dp[start] = Math.min(dp[start],
                            1 + dp[Math.min(n - 1, start + jumpLen)]);
                }
            }

            return dp[0];
        }
    }
}
