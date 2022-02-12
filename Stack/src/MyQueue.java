import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2022-02-10-10:08 PM
 */
public class MyQueue {
    static class Solution1 {
        private Deque<Integer> stack1 = new ArrayDeque<>();
        private Deque<Integer> stack2 = new ArrayDeque<>();
        private int top;

        public void push(int x) {
            if (stack1.isEmpty()) {
                top = x;
            }

            stack1.push(x);

        }

        public int pop() {
            int size = stack1.size();

            for (int i = 0; i < size - 1; i++) {
                top = stack1.pop();
                stack2.push(top);
            }

            int x = stack1.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return x;
        }

        public int peek() {
            return top;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    static class Solution2 {
        private Deque<Integer> stack1 = new ArrayDeque<>();
        private Deque<Integer> stack2 = new ArrayDeque<>();
        private int top;

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            // make sure that stack2 is not empty
            peek();

            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}