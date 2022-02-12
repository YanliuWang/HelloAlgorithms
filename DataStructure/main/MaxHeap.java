/**
 * @author yanliu
 * @create 2021-04-15-17:11
 */
public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] heap;
    private int N;

    public MaxHeap(int capacity) {
        heap = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        heap[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        Key max = heap[1];

        exchange(1, N--);
        sink(1);

        heap[N + 1] = null;

        return max;

    }

    public Key max() {
        return heap[1];
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }

    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            // get the maximum of the children
            if (j < N && less(j, j + 1)) {
                j++;
            }

            // break if parent is bigger than the child
            if (!less(k, j)) {
                break;
            }

            exchange(j, k);

            k = j;
        }

    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;

    }

    private void exchange(int i, int j) {
        Key temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
