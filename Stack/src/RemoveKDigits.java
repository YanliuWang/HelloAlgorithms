import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode402
 * @author yanliu
 * @create 2021-12-22-11:54 AM
 */
public class RemoveKDigits {
    class Solution {
        public String removeKDigits(String num, int k) {
            if (num == null || num.length() == 0) {
                return "";
            }

            Deque<Character> stack = new ArrayDeque<>();

            for (char ch : num.toCharArray()) {
                while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }

                // prevent leading zero
                if (stack.isEmpty() && ch == '0') {
                    continue;
                }

                stack.push(ch);
            }

            // remove from top
            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty()) {
                return "0";
            }

            StringBuilder res = new StringBuilder();

            while (!stack.isEmpty()) {
                res.insert(0, stack.pop());
            }

            return res.toString();
        }
    }
}
