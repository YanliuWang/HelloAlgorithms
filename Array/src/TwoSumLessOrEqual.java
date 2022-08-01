/**
 * LintCode609
 * @author yanliu
 * @create 2022-08-01-12:20 AM
 */
public class TwoSumLessOrEqual {
    static class Solution {
        public int twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int res = 0;
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum <= target) {
                    res += right - left;
                    left++;

                } else {
                    right--;

                }
            }

            return res;

        }
    }
}
