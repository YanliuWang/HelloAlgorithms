import java.util.Random;

/**
 * LeetCode215
 * @author yanliu
 * @create 2021-10-10-12:15 PM
 */
public class KthLargestElement {
    static class Solution {
        /**
         * @param k: An integer
         * @param nums: An array
         * @return: the Kth largest element
         * average time complexity is T(n) = O(n) + T(n / 2) == O(n)
         */
        public static int kthLargestElement(int[] nums, int k) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private static int quickSelect(int[] nums, int start, int end, int k) {
            if (start == end) {
                // in case of array out of bounds
                return nums[start];
            }

            int left = start, right = end;
            int pivot = nums[start + (end - start) / 2];

//            Random rand = new Random();
            // int pivot = nums[start + (end - start) / 2];
//            int pivot_index = left + rand.nextInt(right - left);
//            int pivot = nums[pivot_index];

            while (left <= right) {
                while (left <= right && nums[left] > pivot) {
                    left++;
                }

                while (left <= right && nums[right] < pivot) {
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

            if (start + k - 1 <= right) {
                return quickSelect(nums, start, right, k);
            }

            if (start + k - 1 >= left) {
                return quickSelect(nums, left, end, k - (left - start));
            }

            // if the partition element is the k-th element
            return nums[right + 1];
        }

    }
}
