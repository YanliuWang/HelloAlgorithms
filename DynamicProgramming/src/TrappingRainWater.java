/**
 * LeetCode 42
 * @author yanliu
 * @create 2021-11-18-10:05 PM
 */
public class TrappingRainWater {
    static class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }

            int max = 0;
            int ans = 0;
            int n = height.length;

            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            for (int i = 0; i < n; i++) {
                leftMax[i] = max;
                max = Math.max(max, height[i]);
            }

            max = 0;
            for (int i = n - 1; i >= 0; i--) {
                rightMax[i] = max;
                max = Math.max(max, height[i]);
            }

            for (int i = 1; i < n - 1; i++) {
                ans += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
            }

            return ans;
        }
    }
}
