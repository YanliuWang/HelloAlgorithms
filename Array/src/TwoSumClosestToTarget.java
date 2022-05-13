import java.util.Arrays;

/**
 * LintCode533
 * @author yanliu
 * @create 2022-05-12-3:47 PM
 */
public class TwoSumClosestToTarget {
    class Solution {
        /**
         * @param nums: an integer array
         * @param target: An integer
         * @return: the difference between the sum and the target
         */
        public int twoSumClosest(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return target;
            }

            Arrays.sort(nums);
            int minDiff = Integer.MAX_VALUE;

            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                int diff = Math.abs(sum - target);

                if (diff == 0) {
                    return 0;
                }

                minDiff = Math.min(diff, minDiff);

                if (sum - target > 0) {
                    right--;

                } else {
                    left++;

                }
            }

            return minDiff;
        }
    }
}
