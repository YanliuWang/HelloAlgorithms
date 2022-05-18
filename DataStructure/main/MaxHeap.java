/**
 * @author yanliu
 * @create 2021-04-15-17:11
 */
public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = (Key[]) new Comparable[capacity + 1];
        size = 0;
    }

    public Key deleteMax() {
        if (isEmpty()) {
            return null;
        }

        Key max = heap[1];
        exchange(1, size);

        heap[size] = null;
        size--;

        sink(1);

        return max;

    }

    public void insert(Key elem) {
        if (isEmpty()) {
            return;
        }

        heap[++size] = elem;
        swim(size);
    }

    public Key max() {
        return heap[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length - 1;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }

    }

    private void sink(int k) {
        while (k * 2 <= size) {
            int j = 2 * k;

            // get the maximum of the children
            if (j + 1 <= size && less(j, j + 1)) {
                j = j + 1;
            }

            // break if it is bigger than the maximum of the children
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
