package quicksort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2021-02-18-9:48
 */
public class QuickSort3Way {
    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);

        sort(arr, 0, arr.length - 1);
    }

    /**
     * 三个挡板四个区域
     * arr[lo, lt-1] 小于 v
     * arr[lt, i-1] 等于 v
     * arr[i, gt] 不确定
     * arr[gt+1, hi] 大于 v
     * @param arr
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = arr[lo];

        while (i <= gt) {
            int cmp = arr[i].compareTo(v);

            if (cmp < 0) {
                SortUtils.swap(arr, lt++, i++);

            } else if (cmp > 0) {
                SortUtils.swap(arr, i, gt--);

            } else {
                i++;

            }
        }

        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    public static void main(String[] args) {
        Double[] a = new Double[10];

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
