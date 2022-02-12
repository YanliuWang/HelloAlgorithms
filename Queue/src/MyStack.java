import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode225
 * @author yanliu
 * @create 2022-02-10-8:46 PM
 */
public class MyStack {
    static class Solution1 {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        private int top;

        public void push(int x) {
            q1.offer(x);
            top = x;
        }

        public int pop() {
            while (q1.size() > 1) {
                top = q1.poll();
                q2.offer(top);
            }

            int x = q1.poll();

            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;

            return x;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    static class Solution2 {
        private Queue<Integer> queue = new LinkedList<>();
        private int top;

        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        public int pop() {
            int size = queue.size();

            for (int i = 0; i < size - 1; i++) {
                top = queue.poll();
                queue.offer(top);
            }

            return queue.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}

