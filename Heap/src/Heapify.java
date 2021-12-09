/**
 * @author yanliu
 * @create 2021-10-30-5:36 PM
 */

public class Heapify {
    /**
     * using shift down method to heapify
     * Time Complexity : O(n)
     */
    static class Solution1 {
        public void heapify(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            // if the left child is heap, right child is heap
            // sink the node can construct a heap
            // ****这样操作可以保证 root 是最小值****
            for (int i = (nums.length - 1) / 2; i >= 0; i--) {
                // shift down the elements from the second last layer
                sink(nums, i);
            }
        }

        private void sink(int[] nums, int k) {
            while (k * 2 + 1 < nums.length) {
                // the left son must exist
                int minSon = k * 2 + 1;
                // if the right son exists and less than the left son
                if (k * 2 + 2 < nums.length && nums[k * 2 + 2] < nums[minSon]) {
                    minSon = k * 2 + 2;
                }

                // minHeap
                if (nums[k] <= nums[minSon]) {
                    break;
                }

                swap(nums, k, minSon);

                k = minSon;
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    /**
     * using shift up to heapify
     * Time Complexity : O(n*logn)
     */
    static class Solution2 {
        public void heapify(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                swim(nums, i);
            }
        }

        private void swim(int[] nums, int k) {
            while (k != 0) {
                int parent = (k - 1) / 2;

                if (nums[parent] <= nums[k]) {
                    break;
                }

                swap(nums, k, parent);

                k = parent;
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }


}
