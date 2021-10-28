/**
 * lintcode 31
 * @author yanliu
 * @create 2021-10-23-11:22 PM
 */
public class PartitionArray {
    class Solution {
        /**
         * @param nums: The integer array you should partition
         * @param k: An integer
         * @return: The index after partition
         */
        public int partitionArray(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                while (left <= right && nums[left] < k) {
                    left++;
                }

                while (left <= right && nums[right] >= k) {
                    right--;
                }

                if (left <= right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }

            return left;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
