/**
 * LeetCode55
 * @author yanliu
 * @create 2022-01-16-10:12 AM
 */
public class JumpGameI {
    /**
     * using greedy idea to solve the problem
     */
    static class Solution1 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int farthest = 0;
            for (int i = 0; i < n - 1; i++) {
                // 不断计算能跳到的最远距离
                farthest = Math.max(farthest, i + nums[i]);
                // 可能碰到了 0，卡住跳不动了
                if (farthest == i) {
                    return false;
                }
            }
            return farthest >= n - 1;
        }
    }

    /**
     * using recursive way to solve the problem
     */
    static class Solution2 {
        public boolean canJump(int[] nums) {
            return canJump(0, nums);
        }

        private boolean canJump(int start, int[] nums) {
            if (start == nums.length - 1) {
                return true;
            }

            int furthestJump = Math.min(start + nums[start], nums.length - 1);

            for (int next = furthestJump; next > start; next--) {
                if (canJump(next, nums)) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * using top-down dp to solve the problem
     * optimized backtrack with memo states
     */
    static class Solution3 {
        enum Index {
            GOOD, BAD, UNKNOWN;
        }

        public boolean canJump(int[] nums) {
            Index[] memo = new Index[nums.length];

            for (int i = 0; i < nums.length - 1; i++) {
                memo[i] = Index.UNKNOWN;
            }

            memo[nums.length - 1] = Index.GOOD;

            return canJump(0, memo, nums);
        }

        private boolean canJump(int start, Index[] memo, int[] nums) {
            if (memo[start] != Index.UNKNOWN) {
                return memo[start] == Index.GOOD ? true : false;
            }

            int furthest = Math.min(nums.length - 1, start + nums[start]);

            for (int next = start + 1; next <= furthest; next++) {
                if (canJump(next, memo, nums)) {
                    memo[next] = Index.GOOD;
                    return true;
                }
            }

            memo[start] = Index.BAD;

            return false;
        }


    }

    /**
     * bottom up dp
     * using previous sub-problem result to solve current problem
     */
    static class Solution4 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];

            dp[n - 1] = true;

            for (int i = n - 2; i >= 0; i--) {
                int farthest = Math.min(n - 1, i + nums[i]);

                for (int j = i + 1; j <= farthest; j++) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[0];
        }
    }
}
