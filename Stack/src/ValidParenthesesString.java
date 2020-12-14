import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2020-12-14-10:16
 */
public class ValidParenthesesString {
    static class Solution {
        public boolean checkValidString(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            // we use two stacks to store index of '(' and '*'
            Deque<Integer> leftIdxStack = new ArrayDeque<>();
            Deque<Integer> starIdxStack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    leftIdxStack.push(i);

                } else if (s.charAt(i) == '*') {
                    starIdxStack.push(i);

                } else {
                    if (leftIdxStack.isEmpty()) {
                        if (starIdxStack.isEmpty()) {
                            return false;

                        } else {
                            starIdxStack.pop();

                        }

                    } else {
                        leftIdxStack.pop();

                    }
                }
            }

            if (leftIdxStack.isEmpty()) {
                return true;
            }

            if (leftIdxStack.size() > starIdxStack.size()) {
                return false;

            } else {
                while (!leftIdxStack.isEmpty()) {
                    if (leftIdxStack.pop() > starIdxStack.pop()) {
                        return false;
                    }
                }

                return true;
            }

        }
    }
}
