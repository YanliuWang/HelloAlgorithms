import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-04-17-11:42
 */
public class SlidingWindowMaximum {
    static class Solution {
        /**
         * @param nums: A list of integers.
         * @param k:    An integer
         * @return: The maximum number inside the window at each moving.
         */
        public List<Integer> maxSlidingWindow(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();

            if (nums == null || nums.length < k) {
                return res;
            }

            Deque<Integer> maxNumbersIdx = new ArrayDeque<>(k);

            for (int i = 0; i < nums.length; i++) {
                if (!maxNumbersIdx.isEmpty() && i >= k) {
                    maxNumbersIdx.pollFirst();
                }

                while (!maxNumbersIdx.isEmpty() && nums[i] > nums[maxNumbersIdx.peekLast()]) {
                    maxNumbersIdx.pollLast();
                }

                maxNumbersIdx.addLast(i);

                if (i >= k - 1) {
                    res.add(maxNumbersIdx.peekFirst());
                }
            }

            return res;

        }
    }
}
