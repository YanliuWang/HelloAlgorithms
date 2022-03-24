import java.util.Arrays;

/**
 * LeetCode16
 * @author yanliu
 * @create 2022-03-19-7:56 PM
 */
public class ThreeSumClosest {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            // record the smallest difference
            int diff = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int sum = nums[i] + twoClosestSum(nums, i, target - nums[i]);

                if (Math.abs(diff) > Math.abs(sum - target)) {
                    diff = target - sum;
                }
            }

            return target - diff;
        }

        private int twoClosestSum(int[] nums, int start, int target) {
            int diff = Integer.MAX_VALUE;

            int left = start + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (Math.abs(diff) > Math.abs(sum - target)) {
                    diff = target - sum;

                }

                if (sum < target) {
                    left++;

                } else {
                    right--;

                }
            }

            return target - diff;
        }
    }
}
