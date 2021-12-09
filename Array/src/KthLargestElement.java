/**
 * @author yanliu
 * @create 2021-10-10-12:15 PM
 */
public class KthLargestElement {
    class Solution {
        /**
         * @param k: An integer
         * @param nums: An array
         * @return: the Kth largest element
         * average time complexity is T(n) = O(n) + T(n / 2) == O(n)
         */
        public int kthLargestElement(int k, int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private int quickSelect(int[] nums, int start, int end, int k) {
            if (start == end) {
                // in case of array out of bounds
                return nums[start];
            }

            int i = start, j = end;
            int pivot = nums[start + (end - start) / 2];

            while (i <= j) {
                while (i <= j && nums[i] > pivot) {
                    i++;
                }

                while (i <= j && nums[j] < pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }

            if (start + k - 1 <= j) {
                return quickSelect(nums, start, j, k);
            }

            if (start + k - 1 >= i) {
                return quickSelect(nums, i, end, k - (i - start));
            }

            // if the partition element is the k-th element
            return nums[j + 1];
        }
    }
}
