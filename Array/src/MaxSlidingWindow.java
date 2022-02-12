import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode 239
 * @author yanliu
 * @create 2022-01-04-1:19 PM
 */
public class MaxSlidingWindow {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];

            for (int i = 0; i < nums.length; i++) {
                // remove the out of k range elements
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // the elements are in range k
                // remove the smaller elements in the deque
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.offer(i);

                if (i - k + 1 >= 0) {
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return res;
        }
    }
}
