import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode2116
 * @author yanliu
 * @create 2022-03-15-4:45 PM
 */
public class CheckIfAParenthesesStringCanBeValid {
    // this code has some bugs
    // *********SOS*********
    static class Solution1 {
        public boolean canBeValid(String s, String locked) {
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                if (curr == ')') {
                    if (stack.isEmpty()) {
                        if (locked.charAt(i) == '1') {
                            return false;

                        } else {
                            stack.push(i);

                        }

                    } else {
                        stack.pop();

                    }

                } else {
                    stack.push(i);

                }
            }

            int size = stack.size();

            if (size == 0) {
                return true;
            }

            if (size % 2 == 1) {
                return false;

            }

            int unlockedNumber = 0;

            while (!stack.isEmpty()) {
                if (locked.charAt(stack.pop()) == '0') {
                    unlockedNumber++;
                }
            }

            if (unlockedNumber >= size / 2) {
                return true;
            }

            return false;
        }
    }

    static class Solution2 {
        public boolean canBeValid(String s, String locked) {
            if (s == null || s.length() == 0) {
                return true;
            }

            return s.length() % 2 == 0 && isValid(s, locked, '(')
                    && isValid(s, locked, ')');
        }

        private boolean isValid(String s, String locked, char open) {
            int wild = 0, balance = 0;
            int len = s.length();

            int start = open == '(' ? 0 : len - 1;
            int dir = open == '(' ? 1 : -1;

            for (int i = start; i >= 0 && i < len; i += dir) {
                if (locked.charAt(i) == '1') {
                    balance += s.charAt(i) == open ? 1 : -1;

                } else {
                    wild++;

                }

                if (balance + wild < 0) {
                    return false;

                }
            }

            return balance <= wild;
        }
    }
}
