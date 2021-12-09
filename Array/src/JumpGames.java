/**
 * LeetCode55
 * @author yanliu
 * @create 2021-12-06-10:05 AM
 */
public class JumpGames {
    static class Solution {
        public boolean canJump(int[] nums) {
            int maxDistSoFar = 0;

            for (int i = 0; i <= maxDistSoFar; i++) {
                maxDistSoFar = Math.max(maxDistSoFar, i + nums[i]);

                if (maxDistSoFar >= nums.length - 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
