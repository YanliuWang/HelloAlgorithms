import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode32
 * @author yanliu
 * @create 2021-12-04-11:02 AM
 */
public class LongestValidParentheses {
    static class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            // store the index of the last unmatched closed bracket
            // store the index of unmatched open bracket
            // store the index of unmatched open bracket
            Deque<Integer> stack = new ArrayDeque<>();

            // the initial index of last unmatched bracket is -1
            stack.push(-1);

            int ans = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);

                } else {
                    stack.pop();

                    if (stack.isEmpty()) {
                        // update the index of last unmatched bracket
                        stack.push(i);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                }
            }

            return ans;
        }
    }
}
