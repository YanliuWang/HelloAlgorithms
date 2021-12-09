/**
 * 剑指offer 51
 * @author yanliu
 * @create 2021-11-06-9:53 AM
 */
public class ReversePairs {
    class Solution {
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // copy the input array to avoid change the input data
            int[] copy = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                copy[i] = nums[i];
            }

            return sortAndCount(copy, 0, copy.length - 1, new int[copy.length]);
        }

        private int sortAndCount(int[] nums, int start, int end, int[] auxiliary) {
            if (start >= end) {
                return 0;
            }

            int mid = start + (end - start) / 2;
            // the left side is sorted
            int leftPairs = sortAndCount(nums, start, mid, auxiliary);

            // the right side is sorted
            int rightPairs = sortAndCount(nums, mid + 1, end, auxiliary);

            // all the left side elements are less than the right side elements
            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }

            int crossPairs = mergeAndCount(nums, start, mid, end, auxiliary);

            return leftPairs + rightPairs + crossPairs;
        }

        private int mergeAndCount(int[] nums, int start, int mid, int end, int[] auxiliary) {
            int leftStart = start, rightStart = mid + 1;
            int index = start;
            int count = 0;

            while (leftStart <= mid && rightStart <= end) {
                if (nums[leftStart] <= nums[rightStart]) {
                    auxiliary[index] = nums[leftStart];
                    leftStart++;

                } else {
                    auxiliary[index] = nums[rightStart];
                    count += mid - leftStart + 1;
                    rightStart++;
                }

                index++;
            }

            while (leftStart <= mid) {
                auxiliary[index++] = nums[leftStart++];
            }

            while (rightStart <= end) {
                auxiliary[index++] = nums[rightStart++];
            }

            for (int i = start; i <= end; i++) {
                nums[i] = auxiliary[i];
            }

            return count;
        }

    }
}
