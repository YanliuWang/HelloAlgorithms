import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * LeetCode198
 * @author yanliu
 * @create 2021-12-14-11:10 PM
 */
public class HouseRobber {
    /**
     * recursive way to solve the problem
     * try all options and get the max value
     */
    static class Solution1 {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] memo = new int[n];
            Arrays.fill(memo, -1);

            return robHouse(0, nums, memo);

        }

        private int robHouse(int start, int[] nums, int[] memo) {
            if (start >= nums.length) {
                return 0;
            }

            if (memo[start] != -1) {
                return memo[start];
            }

            int ans = Math.max(robHouse(start + 1, nums, memo),
                    nums[start] + robHouse(start + 2, nums, memo));

            memo[start] = ans;

            return memo[start];
        }
    }

    /**
     * using dp to solve the problem
     */
    static class Solution2 {
        public int rob(int[] nums) {
            int N = nums.length;
            int[] dp = new int[N + 1];

            dp[N - 1] = nums[N - 1];
            dp[N] = 0;


            for (int i = N - 2; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
            }

            return dp[0];
        }
    }

    /**
     * optimized dp
     */
    static class Solution3 {
        public int rob(int[] nums) {
            int N = nums.length;

            int robNext = nums[N - 1];
            int robNextPlusOne = 0;


            for (int i = N - 2; i >= 0; i--) {
                int current = Math.max(robNext, nums[i] + robNextPlusOne);

                robNextPlusOne = robNext;
                robNext = current;

            }

            return robNext;
        }


    }

    static class Solution4 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            int N = nums.length;

            int[] dp = new int[N];

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            return dp[N - 1];

        }
    }

    static class Solution5 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            int rob1 = nums[0];
            int rob2 = Math.max(nums[0], nums[1]);

            int res = 0;

            for (int i = 2; i < nums.length; i++) {
                int curr = Math.max(rob1 + nums[i], rob2);

                rob1 = rob2;
                rob2 = curr;
            }

            return rob2;
        }
    }





}
