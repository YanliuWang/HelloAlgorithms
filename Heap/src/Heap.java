/**
 * @author yanliu
 * @create 2020-12-08-10:51
 */
public class Heap {
    private int[] heap;
    private int heapSize;

    public Heap(int len) {
        if (len < 1) {
            throw new IndexOutOfBoundsException();
        }

        heap = new int[len];
        heapSize = len;
    }

    public int parent(int index) {
        if (index > heapSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        return heap[index / 2];
    }

    public int left(int index) {
        if (index > (heapSize - 1) / 2) {
            throw new IndexOutOfBoundsException();
        }

        return heap[index * 2];
    }


    public int right(int index) {
        if (index > (heapSize - 1) / 2 - 1) {
            throw new IndexOutOfBoundsException();
        }

        return heap[index * 2 + 1];
    }
}
