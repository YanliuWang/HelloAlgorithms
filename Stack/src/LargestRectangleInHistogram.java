import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode84
 * @author yanliu
 * @create 2021-12-21-8:49 AM
 */
public class LargestRectangleInHistogram {
    static class Solution1 {
        public int largestRectangleArea(int[] heights) {
            // using monoStack to get the first less left and the first less right
            Deque<Integer> monoStack = new ArrayDeque<>();
            int n = heights.length;
            int[] firstLeftLess = new int[n];
            int[] firstRightLess = new int[n];

            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }

                firstLeftLess[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                monoStack.push(i);
            }

            monoStack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }

                firstRightLess[i] = monoStack.isEmpty() ? n : monoStack.peek();
                monoStack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (firstRightLess[i] - firstLeftLess[i] - 1) * heights[i]);
            }

            return ans;


        }
    }

    static class Solution2 {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> monoStack = new ArrayDeque<>();
            monoStack.push(-1);

            int maxArea = 0;

            for (int i = 0; i < heights.length; i++) {
                while (monoStack.peek() != -1 && heights[monoStack.peek()] > heights[i]) {
                    int height = heights[monoStack.pop()];
                    int width = i - monoStack.peek() - 1;

                    maxArea = Math.max(maxArea, height * width);
                }

                monoStack.push(i);
            }

            int length = heights.length;

            while (monoStack.peek() != -1) {
                int height = heights[monoStack.pop()];
                int width = length - monoStack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            return maxArea;
        }
    }
}
