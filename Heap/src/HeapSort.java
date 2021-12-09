/**
 * @author yanliu
 * @create 2021-10-30-8:03 PM
 */
public class HeapSort {
    static class Solution {
        public void heapSort(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }

            // use max-heap to get ascending order
            heapify(nums);

            for (int right = nums.length - 1; right > 0; right--) {
                swap(nums, 0, right);

                // shift down the swapped element from top down
                sink(nums, 0, right - 1);
            }
        }

        private void heapify(int[] nums) {
            for (int i = (nums.length - 1) / 2; i >= 0; i--) {
                sink(nums, i, nums.length - 1);
            }
        }

        private void sink(int[] nums, int left, int right) {
            int k = left;

            while (k * 2 + 1 <= right) {
                int maxChild = k * 2 + 1;

                // get the max son from left and right child
                if (maxChild + 1 <= right && nums[maxChild + 1] > nums[maxChild]) {
                    maxChild = maxChild + 1;
                }

                if (nums[k] >= nums[maxChild]) {
                    break;
                }

                swap(nums, k, maxChild);

                k = maxChild;
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }

    }
}
