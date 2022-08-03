import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode2104
 * @author yanliu
 * @create 2022-08-01-11:37 PM
 */
public class SumOfSubarrayRanges {
    static class Solution1 {
        public long subArrayRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            long res = 0;

            for (int i = 0; i < nums.length; i++) {
                int min = nums[i];
                int max = nums[i];

                for (int j = i; j < nums.length; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    res += max - min;
                }
            }

            return res;
        }
    }

    static class Solution2 {
        public long subArrayRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            long res = 0;
            int n = nums.length;

            int[] minPrev = new int[n];
            int[] minNext = new int[n];
            int[] maxPrev = new int[n];
            int[] maxNext = new int[n];



            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    stack.pop();
                }

                minPrev[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    stack.pop();
                }

                minNext[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }

                maxPrev[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    stack.pop();
                }

                maxNext[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                long leftMin = i - minPrev[i];
                long rightMin = minNext[i] - i;
                long leftMax = i - maxPrev[i];
                long rightMax = maxNext[i] - i;

                res += (leftMax * rightMax - leftMin * rightMin) * nums[i];
            }

            return res;
        }
    }
}
