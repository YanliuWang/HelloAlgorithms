import java.util.Stack;

/**
 * @author yanliu
 * @create 2020-11-23-14:35
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 */
public class SortedStack {
    Stack<Integer> data;
    Stack<Integer> help;

    public SortedStack() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int val) {
        if (!data.isEmpty() && val > data.peek()) {
            while (!data.isEmpty() && val > data.peek()) {
                help.push(data.pop());
            }

            data.push(val);

            while (!help.isEmpty()) {
                data.push(help.pop());
            }
        } else {
            data.push(val);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
        }
    }

    public int peek() {
        if (!data.isEmpty()) {
            return data.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
