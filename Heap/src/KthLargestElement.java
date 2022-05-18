import java.util.PriorityQueue;

/**
 * LeetCode215
 * @author yanliu
 * @create 2021-04-17-11:37
 */
public class KthLargestElement {
    static class Solution {
        /**
         * @param k: An integer
         * @param nums: An array
         * @return: the Kth largest element
         */
        public int kthLargestElement(int k, int[] nums) {
            // write your code here
            if (nums == null || nums.length < k) {
                return Integer.MIN_VALUE;
            }

            // use to store k largest elements in the array
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                if (nums[i] >= minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }

            return minHeap.poll();
        }
    }
}
