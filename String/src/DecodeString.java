import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode394
 * @author yanliu
 * @create 2022-04-05-4:30 PM
 */
public class DecodeString {
    static class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            // use stack to record previous characters
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                if (curr != ']') {
                    stack.push(curr);
                    continue;
                }

                List<Character> decodedString = new ArrayList<>();

                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }

                // pop '[' in the head of stack
                stack.pop();

                // count the number
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                // push the string at relative order
                while (k > 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }

                    k--;
                }

            }

            char[] res = new char[stack.size()];

            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }

            return new String(res);
        }
    }
}
