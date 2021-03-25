import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2020-11-24-9:28
 */
public class MinStack {
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
    public MinStack() {
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