package mergesort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-11-28-10:20
 */
public class MergeSort {
    public static void sortRecursion(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        Comparable[] aux = new Comparable[arr.length];

        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);

        if (SortUtils.less(arr[mid], arr[mid + 1])) {
            return;
        }

        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        // move all elements in arr to helper
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        // merge
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // the left halve elements are all used
                // put the right halve elements to arr
                arr[k] = aux[j++];

            } else if (j > hi) {
                // the right halve elements are all used
                // put the left halve elements to arr
                arr[k] = aux[i++];

            } else if (SortUtils.less(aux[j], aux[i])) {
                // maintain stability
                arr[k] = aux[j++];

            } else {
                arr[k] = aux[i++];
            }

        }

    }

    /**
     * iterative merge sort
     * from bottom up
     * @param arr
     */
    public static void sortIteration(Comparable[] arr) {
        int N = arr.length;

        Comparable[] aux = new Comparable[N];

        for (int currSize = 1; currSize < N; currSize *= 2) {
            for (int lo = 0; lo < N - currSize; lo += currSize * 2) {
                merge(arr, aux, lo, lo + currSize - 1, Math.min(lo + currSize + currSize - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Double[] a = new Double[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }

        sortRecursion(a);

        if (SortUtils.isSorted(a)) {
            System.out.println("sort succeeded");

        } else {
            System.out.println("sort failed");

        }
    }
}
