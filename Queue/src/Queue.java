/**
 * LintCode492
 * @author yanliu
 * @create 2022-08-10-10:41 AM
 */
public class Queue {
    private final int MAX_SIZE = 1000;
    private int[] queue;
    private int head;
    private int tail;

    public Queue() {
        queue = new int[MAX_SIZE];
        head = 0;
        tail = 0;
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        if ((tail + 1) % MAX_SIZE == head) {
            return;
        }

        // write your code here
        queue[tail++] = item;
        tail %= MAX_SIZE;

    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head == tail) {
            return -1;
        }

        int val = queue[head++];

        head %= MAX_SIZE;

        return val;

    }
}
