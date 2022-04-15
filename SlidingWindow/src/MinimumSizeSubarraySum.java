/**
 * LeetCode209
 * @author yanliu
 * @create 2022-04-04-6:23 PM
 */
public class MinimumSizeSubarraySum {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = 0;
            int sum = 0;
            int size = Integer.MAX_VALUE;

            while (right < nums.length) {
                int in = nums[right];
                sum += in;
                right++;

                while (right - left > 0 && sum >= target) {
                    size = Math.min(size, right - left);

                    int out = nums[left];
                    sum -= out;
                    left++;
                }
            }

            return size == Integer.MAX_VALUE ? 0 : size;


        }
    }
}
