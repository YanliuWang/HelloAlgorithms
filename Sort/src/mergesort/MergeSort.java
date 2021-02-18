package mergesort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-11-28-10:20
 */
public class MergeSort {
    /**
     * recursion merge sort
     * top down
     * @param arr
     */
    private static Comparable[] helper;

    public static void sortRecursion(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        helper = new Comparable[arr.length];

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        // move all elements in arr to helper
        for (int k = lo; k <= hi; k++) {
            helper[k] = arr[k];
        }

        // merge
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // the left side elements are all used
                // put the right side elements to arr
                arr[k] = helper[j++];

            } else if (j > hi) {
                // the right side elements are all used
                // put the left side elements to arr
                arr[k] = helper[i++];

            } else if (SortUtils.less(helper[j], helper[i])) {
                arr[k] = helper[j++];

            } else {
                arr[k] = helper[i++];
            }

        }

    }

    /**
     * iterative merge sort
     * from bottom up
     * @param arr
     */
    public static void sortIteration(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        helper = new Comparable[N];

        // from bottom up to increase the sort sequence size
        for (int currSize = 1; currSize < N; currSize *= 2) {
            // lo < N-currSize makes sure mid can be cover the last element
            for (int lo = 0; lo < N - currSize; lo += currSize * 2) {
                merge(arr, lo, lo + currSize - 1, Math.min(lo + currSize + currSize - 1, N - 1));
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

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
