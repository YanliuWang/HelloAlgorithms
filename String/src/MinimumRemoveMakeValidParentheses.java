import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode1249
 * @author yanliu
 * @create 2022-03-14-6:47 PM
 */
public class MinimumRemoveMakeValidParentheses {
    static class Solution {
        public String minRemoveToMakeValid(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            Set<Integer> removed = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                if (curr == '(') {
                    stack.push(i);

                } else if (curr == ')') {
                    if (stack.isEmpty()) {
                        removed.add(i);

                    } else {
                        stack.pop();

                    }
                }
            }


            while (!stack.isEmpty()) {
                removed.add(stack.pop());
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (removed.contains(i)) {
                    continue;
                }

                sb.append(s.charAt(i));
            }

            return sb.toString();
        }
    }
}
