import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2020-11-23-22:22
 */
public class NextGreatNumberII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null | nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * n - 1; i > -1; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            res[i % n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i % n]);
        }

        return res;

    }
}
