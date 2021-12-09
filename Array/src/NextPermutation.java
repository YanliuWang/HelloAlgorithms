/**
 * LeetCode31
 * @author yanliu
 * @create 2021-12-01-10:46 AM
 */
public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }

            // find the first pair nums[i] < nums[i + 1] from right
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }

            // find the first nums[j] > nums[i]
            if (i >= 0) {
                int j = nums.length - 1;

                while (nums[j] <= nums[i]) {
                    j--;
                }

                // swap the two numbers
                swap(nums, i, j);
            }

            // reverse the i right numbers to ascending order
            reverse(nums, i + 1);

        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }

        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;

            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}
