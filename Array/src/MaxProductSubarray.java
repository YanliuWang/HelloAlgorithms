/**
 * LeetCode 152
 * @author yanliu
 * @create 2021-11-15-4:12 PM
 */
public class MaxProductSubarray {
    static class Solution1 {
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

    static class Solution2 {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int maxSoFar = 1;
            int minSoFar = 1;
            int res = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];

                int maxTemp = Math.max(curr, Math.max(curr * maxSoFar, curr * minSoFar));

                minSoFar = Math.min(curr, Math.min(curr * maxSoFar, curr * minSoFar));

                maxSoFar = maxTemp;

                res = Math.max(res, maxSoFar);
            }

            return res;


        }
    }
}
