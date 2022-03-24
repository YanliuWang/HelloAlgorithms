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
    static class Solution1 {
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

    static class Solution2 {
        public String minRemoveToMakeValid(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            StringBuilder res = new StringBuilder();

            res = remove(s, '(', ')');
            res = remove(res.toString(), ')', '(');

            return res.reverse().toString();
        }

        private StringBuilder remove(String s, char open, char close) {
            StringBuilder res = new StringBuilder();

            int start = open == '(' ? 0 : s.length() - 1;
            int move = open == '(' ? 1 : -1;
            int balance = 0;

            for (int i = start; i >= 0 && i < s.length(); i += move) {
                char curr = s.charAt(i);

                if (curr == open) {
                    balance++;

                } else if (curr == close){
                    if (balance == 0) {
                        continue;
                    }

                    balance--;
                }

                res.append(curr);
            }

            return res;
        }
    }
}
