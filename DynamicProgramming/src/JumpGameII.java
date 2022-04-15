import java.util.Arrays;

/**
 * LeetCode45
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
                int furthest = Math.min(n - 1, start + nums[start]);

                for (int next = start + 1; next <= furthest; next++) {
                    dp[start] = Math.min(dp[start], 1 + dp[next]);
                }
            }

            return dp[0];
        }
    }

    static class Solution3 {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int currEnd = 0;
            int farthest = 0;
            int n = nums.length;
            int jump = 0;

            for (int currStart = 0; currStart < n - 1; currStart++) {
                farthest = Math.max(farthest, currStart + nums[currStart]);

                if (currStart == currEnd) {
                    currEnd = farthest;
                    jump++;
                }
            }

            return jump;
        }
    }
}
