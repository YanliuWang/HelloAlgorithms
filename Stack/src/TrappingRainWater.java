import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode42
 * @author yanliu
 * @create 2021-12-29-10:18 AM
 */
public class TrappingRainWater {
    static class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int ans = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int curr = stack.pop();

                    if (stack.isEmpty()) {
                        break;
                    }

                    int distance = i - stack.peek() - 1;
                    int bound = Math.min(height[i], height[stack.peek()]);

                    ans += Math.max(0, bound - height[curr]) * distance;
                }

                stack.push(i);

            }

            return ans;
        }
    }
}
