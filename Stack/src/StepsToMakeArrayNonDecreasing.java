import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode2289
 * @author yanliu
 * @create 2022-05-29-10:49 AM
 */
public class StepsToMakeArrayNonDecreasing {
    class Solution {
        public int totalSteps(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }

            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{nums[0], 0});

            int res = 0;

            for (int i = 1; i < nums.length; i++) {
                int steps = 0;

                while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                    steps = Math.max(steps, stack.peek()[1]);
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    steps = 0;

                } else {
                    steps += 1;

                }

                res = Math.max(res, steps);

                stack.push(new int[]{nums[i], steps});
            }

            return res;
        }
    }
}
