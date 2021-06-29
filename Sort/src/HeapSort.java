import edu.princeton.cs.algs4.StdRandom;

/**
 * @author yanliu
 * @create 2021-04-15-17:35
 */
public class HeapSort {
    public static void sort(Comparable[] keys) {
        int N = keys.length - 1;

        for (int k = N / 2; k >= 1; k--) {
            sink(keys, k, N);
        }

        while (N > 1) {
            exchange(keys, 1, N);
            sink(keys, 1, --N);
        }
    }

    private static void sink(Comparable[] keys, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(keys, j, j + 1)) {
                j++;
            }

            if (!less(keys, k, j)) {
                break;
            }

            exchange(keys, k , j);

            k = j;
        }
    }

    private static void exchange(Comparable[] keys, int i, int j) {
        Comparable tmp = keys[i];
        keys[i] = keys[j];
        keys[j] = tmp;
    }

    private static boolean less(Comparable[] keys, int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    public static void main(String[] args) {
        Double[] a = new Double[10];

        for (int i = 1; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }

        sort(a);

        for (Comparable key : a) {
            System.out.println(key);
        }
    }
}
