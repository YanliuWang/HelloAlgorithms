/**
 * LeetCode 152
 * @author yanliu
 * @create 2021-11-15-4:12 PM
 */
public class MaxProductSubarray {
    static class Solution {
        public int maxProduct(int[] nums) {
            // the max product end with i-th index
            int currMax = 1;

            // the min product end with i-th index
            int currMin = 1;

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                // if the number is negative
                // exchange the max and min
                if (nums[i] < 0) {
                    int tmp = currMax;
                    currMax = currMin;
                    currMin = tmp;
                }

                // update the max and min if necessary
                currMax = Math.max(currMax * nums[i], nums[i]);
                currMin = Math.min(currMin * nums[i], nums[i]);

                max = Math.max(max, currMax);
            }

            return max;
        }
    }
}
