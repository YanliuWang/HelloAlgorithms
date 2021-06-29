import edu.princeton.cs.algs4.StdRandom;

/**
 * @author yanliu
 * @create 2020-12-01-21:33
 */
public class ShellSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SortUtils.less(arr[j], arr[j - h]); j -= h) {
                    SortUtils.swap(arr, j, j - h);
                }
            }

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Double a[] = new Double[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }

        sort(a);

        if (SortUtils.isSorted(a)) {
            System.out.println("sort succeeded");

        } else {
            System.out.println("sort failed");

        }
    }
}
