/**
 * LeetCode746
 * @author yanliu
 * @create 2022-04-21-9:44 AM
 */
public class MinCostClimbingStairs {
    static class Solution1 {
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) {
                return 0;
            }

            int n = cost.length;
            int[] dp = new int[n];

            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < n; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }

            return Math.min(dp[n - 2], dp[n - 1]);

        }
    }

    static class Solution2 {
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length < 2) {
                return 0;
            }

            int oneStep = cost[0];
            int twoStep = cost[1];
            int res = Integer.MAX_VALUE;

            for (int i = 2; i < cost.length; i++) {
                res = Math.min(oneStep, twoStep) + cost[i];

                oneStep = twoStep;
                twoStep = res;
            }

            return Math.min(oneStep, twoStep);

        }
    }
}
