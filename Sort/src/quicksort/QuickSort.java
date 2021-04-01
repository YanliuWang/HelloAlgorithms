package quicksort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-12-02-10:18
 */
public class QuickSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);

    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo < hi) {
            int j = partition(arr, lo, hi);

            sort(arr, lo, j - 1);
            sort(arr, j + 1, hi);
        }
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int pivot = lo;

        int i = lo + 1;
        int j = hi;

        while (i <= j) {
            while (i <= j && SortUtils.less(arr[i], arr[pivot])) {
                i++;
            }

            while (i <= j && SortUtils.less(arr[pivot], arr[j])) {
                j--;
            }

            if (i <= j) {
                SortUtils.swap(arr, i, j);
                i++;
                j--;
            }
        }

        SortUtils.swap(arr, pivot, j);

        return j;
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
