import java.util.ArrayDeque;
import java.util.Deque;

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
            int N = s.length();
            Deque<Object> stack = new ArrayDeque<>();
            int n = 0, operand = 0;

            // calculate the expression in reverse order
            for (int i = N - 1; i >= 0; i--) {
                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    operand = (int) Math.pow(10, n) * (ch - '0') + operand;
                    n++;

                } else if (ch != ' ') {
                    // the character is not digit
                    // update previous operand
                    if (n != 0) {
                        stack.push(operand);
                        n = 0;
                        operand = 0;

                    }

                    if (ch == '(') {
                        // get the result
                        int res = evaluateExpr(stack);

                        // pop the ')' on the stack
                        stack.pop();

                        // put the result for future calculation
                        stack.push(res);

                    } else {
                        stack.push(ch);

                    }
                }

            }

            // add the last operand to stack
            if (n != 0) {
                stack.push(operand);
            }

            return evaluateExpr(stack);
        }

        private int evaluateExpr(Deque<Object> stack) {
            // make sure that the top of stack is an integer
            if (stack.isEmpty() || !(stack.peek() instanceof Integer)) {
                stack.push(0);
            }

            int res = (int) stack.pop();

            // get the result
            while (!stack.isEmpty() && ((char) stack.peek() != ')')) {
                // make sure that the top is sign character
                char sign = (char) stack.pop();

                if (sign == '+') {
                    res += (int) stack.pop();

                } else {
                    res -= (int) stack.pop();
                }
            }

            return res;
        }
    }

    /**
     * LeetCode227
     */
    static class Solution2 {
        public int calculate(String s) {
            int N = s.length();
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            char operation = '+';
            int currNumber = 0;


            for (int i = 0; i < N; i++) {
                char currChar = s.charAt(i);

                if (Character.isDigit(currChar)) {
                    currNumber = currNumber * 10 + (currChar - '0');

                }

                if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == N - 1) {
                    if (operation == '+') {
                        stack.push(currNumber);

                    } else if (operation == '-') {
                        stack.push(-currNumber);

                    } else if (operation == '*') {
                        stack.push(stack.pop() * currNumber);

                    } else if (operation == '/') {
                        stack.push(stack.pop() / currNumber);

                    }

                    operation = currChar;
                    currNumber = 0;
                }
            }

            while (!stack.isEmpty()) {
                res += stack.pop();
            }

            return res;
        }
    }

    /**
     * LeetCode772
     */
}
