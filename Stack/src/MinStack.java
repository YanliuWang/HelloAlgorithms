import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode155
 * @author yanliu
 * @create 2020-11-24-9:28
 */
public class MinStack {
    class Solution1 {
        /**
         * store all values
         */
        Deque<Integer> stack1;

        /**
         * store the min value
         */
        Deque<Integer> stack2;

        /**
         * initialize your data structure here.
         */
        public Solution1() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);

            if (stack2.isEmpty() || x <= getMin()) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (top() == getMin()) {
                stack2.pop();
            }

            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

    class Solution2 {
        private int min;
        private Deque<Integer> stack;

        public Solution2() {
            min = Integer.MAX_VALUE;
            stack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }

            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }


}