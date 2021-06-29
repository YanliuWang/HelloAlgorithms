import edu.princeton.cs.algs4.StdRandom;

/**
 * @author yanliu
 * @create 2020-11-29-17:23
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        StdRandom.shuffle(arr);

        int N = arr.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 1 && SortUtils.less(j, j - 1); j--) {
                    SortUtils.swap(arr, j, j - 1);
            }
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
