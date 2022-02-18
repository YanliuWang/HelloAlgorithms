import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2022-01-24-6:38 PM
 */
public class BasicCalculator {
    /**
     * LeetCode224
     */
    static class Solution1 {
        public int calculate(String s) {
            return calculate(s, 0)[1];
        }

        private int[] calculate(String s, int start) {
            int result = 0;
            int operand = 0;
            int sign = 1;
            int i = start;

            while (i < s.length()) {
                char ch = s.charAt(i++);

                if (ch == ' ' || Character.isDigit(ch)) {
                    operand = ch == ' ' ? operand : operand * 10 + (ch - '0');

                } else if (ch == '(') {
                    int[] subRes = calculate(s, i);
                    i = subRes[0];
                    operand = subRes[1];

                } else if (ch == ')') {
                    break;

                } else {
                    result += sign * operand;
                    operand = 0;
                    sign = ch == '+' ? 1 : -1;

                }
            }

            return new int[]{i, result + sign * operand};
        }
    }

    /**
     * LeetCode227
     */
    static class Solution2 {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();

            int operand = 0;
            char operator = '+';
            int res = 0;
            int N = s.length();

            for (int i = 0; i < N; i++) {
                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    operand = operand * 10 + (ch - '0');

                }

                // meet new operator
                // calcuate pervious operand
                if (!Character.isDigit(ch) && ch != ' '
                        || i == N - 1) {
                    if (operator == '+') {
                        stack.push(operand);

                    } else if (operator == '-') {
                        stack.push(-operand);

                    } else if (operator == '*') {
                        stack.push(stack.pop() * operand);

                    } else if (operator == '/') {
                        stack.push(stack.pop() / operand);

                    }

                    operator = ch;
                    operand = 0;
                }
            }

            while (!stack.isEmpty()) {
                res += stack.pop();
            }

            return res;
        }
    }

    /**
     * Leetcode772
     */
    static class Solution3 {
        public int calculate(String s) {
            Queue<Character> str = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch != ' ') {
                    str.offer(ch);
                }
            }

            return calculate(str);
        }

        private int calculate(Queue<Character> str) {
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            int operand = 0;
            char operator = '+';

            while (!str.isEmpty()) {
                char ch = str.poll();

                if (ch == ' ' || Character.isDigit(ch)) {
                    operand = ch == ' ' ? operand : operand * 10 + (ch - '0');

                }

                if (ch == '(') {
                    operand = calculate(str);

                }

                if (!Character.isDigit(ch) || str.isEmpty()) {
                    if (operator == '+') {
                        stack.push(operand);

                    } else if (operator == '-') {
                        stack.push(-operand);

                    } else if (operator == '*') {
                        stack.push(stack.pop() * operand);

                    } else if (operator == '/') {
                        stack.push(stack.pop() / operand);

                    }

                    operator = ch;
                    operand = 0;
                }

                if (ch == ')') {
                    break;
                }
            }

            while (!stack.isEmpty()) {
                res += stack.pop();
            }

            return res;
        }
    }

}
