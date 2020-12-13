import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2020-12-13-23:09
 */
public class ValidParentheses {
    static class Solution {
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

    public static void main(String[] args) {
        String s1 = "()()[][]";
        String s2 = "()()[[][";
        System.out.println(s1 + ":" + new Solution().isValid(s1));
        System.out.println(s2 + ":" + new Solution().isValid(s2));

    }
}
