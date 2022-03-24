import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode1762
 * @author yanliu
 * @create 2022-03-21-5:03 PM
 */
public class BuildingsWithAnOceanView {
    static class Solution1 {
        public int[] findBuildings(int[] heights) {
            if (heights == null || heights.length == 0) {
                return new int[0];
            }

            Deque<Integer> monoStack = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();

            for (int i = heights.length - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && heights[i] > monoStack.peek()) {
                    monoStack.pop();
                }

                if (monoStack.isEmpty()) {
                    res.add(i);
                }

                monoStack.push(heights[i]);

            }

            int[] ans = new int[res.size()];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = res.get(res.size() - 1 - i);
            }

            return ans;
        }
    }

    static class Solution2 {
        public int[] findBuildings(int[] heights) {
            if (heights == null || heights.length == 0) {
                return new int[0];
            }

            int maxHeight = Integer.MIN_VALUE;
            List<Integer> res = new ArrayList<>();

            for (int i = heights.length - 1; i >= 0; i--) {
                if (heights[i] > maxHeight) {
                    res.add(i);
                    maxHeight = heights[i];

                }
            }

            int[] ans = new int[res.size()];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = res.get(res.size() - 1 - i);
            }

            return ans;

        }
    }
}
