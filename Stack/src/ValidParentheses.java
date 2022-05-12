import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode20
 * @author yanliu
 * @create 2020-12-13-23:09
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }

            char[] parentheses = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>(parentheses.length);

            for (char c : parentheses) {
                if (c == '(') {
                    stack.push(')');

                } else if (c == '[') {
                    stack.push(']');

                } else if (c == '{') {
                    stack.push('}');

                } else {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
