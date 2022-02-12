import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode402
 * @author yanliu
 * @create 2021-12-22-11:54 AM
 */
public class RemoveKDigits {
    static class Solution {
        public String removeKDigits(String num, int k) {
            int len = num.length();

            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < len; i++) {
                char ch = num.charAt(i);

                while (k != 0 && !stack.isEmpty() && stack.peek() > ch) {
                    stack.pop();
                    k--;
                }

                if (stack.isEmpty() && ch == '0') {
                    continue;
                }

                stack.push(ch);
            }

            StringBuilder sb = new StringBuilder();

            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
