import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode85
 * @author yanliu
 * @create 2021-12-22-11:22 AM
 */
public class MaximalRectangle {
    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            int[] heights = new int[col];
            int ans = -1;

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (matrix[r][c] == '1') {
                        heights[c]++;

                    } else {
                        heights[c] = 0;
                    }
                }

                int area = largestRectangleArea(heights);
                ans = Math.max(ans, area);
            }

            return ans;
        }

        private int largestRectangleArea(int[] heights) {
            int n = heights.length;

            int[] lessLeftFirst = new int[n];
            int[] lessRightFirst = new int[n];

            Deque<Integer> monoStack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }

                lessLeftFirst[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                monoStack.push(i);
            }

            monoStack.clear();

            for (int i = n - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }

                lessRightFirst[i] = monoStack.isEmpty() ? n : monoStack.peek();
                monoStack.push(i);
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (lessRightFirst[i] - lessLeftFirst[i] - 1) * heights[i]);
            }

            return ans;
        }
    }
}
