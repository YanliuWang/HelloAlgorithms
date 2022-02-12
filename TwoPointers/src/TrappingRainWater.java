/**
 * LeetCode 42
 * @author yanliu
 * @create 2021-11-18-10:05 PM
 */
public class TrappingRainWater {
    static class Solution {
        public int trap(int[] height) {
            int leftMax = 0, rightMax = 0;
            int left = 0, right = height.length - 1;
            int ans = 0;

            while (left <= right) {
                if (height[left] < height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];

                    } else {
                        ans += leftMax - height[left];

                    }

                    left++;

                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];

                    } else {
                        ans += rightMax - height[right];
                    }

                    right--;
                }
            }

            return ans;
        }
    }
}
