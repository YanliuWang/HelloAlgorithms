/**
 * @author yanliu
 * @create 2021-10-10-12:49 PM
 */
public class Median {
    class Solution {
        /**
         * @param nums: A list of integers
         * @return: An integer denotes the middle number of the array
         */
        public int median(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            return quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2 - 1);
        }

        private int quickSelect(int[] nums, int start, int end, int medianDistance) {
            if (start == end) {
                return nums[start];
            }

            int left = start, right = end;
            int pivot = nums[left + (right - left) / 2];

            while (left <= right) {
                while (left <= right && nums[left] < pivot) {
                    left++;
                }

                while (left <= right && nums[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }

            if (start + medianDistance <= right) {
                return quickSelect(nums, start, right, medianDistance);
            }

            if (start + medianDistance >= left) {
                return quickSelect(nums, left, end, medianDistance - (left - start));
            }

            return nums[right + 1];
        }
    }
}
