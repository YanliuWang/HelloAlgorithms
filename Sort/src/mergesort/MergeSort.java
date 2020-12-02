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

        sort(arr, 0, arr.length - 1);

    }

    private static void sort(Comparable[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] helper = new Comparable[right - left + 1];

        int i = 0, j = left, k = mid + 1;

        while (j <= mid && k <= right) {
            helper[i++] = SortUtils.less(arr[k], arr[j]) ? arr[k++] : arr[j++];
        }

        while (j <= mid) {
            helper[i++] = arr[j++];
        }

        while (k <= right) {
            helper[i++] = arr[k++];
        }

        for (i = 0; i < helper.length; i++) {
            arr[i + left] = helper[i];
        }

    }

    public static void sortIteration(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        for (int currSize = 1; currSize < N; currSize *= 2) {
            for (int lo = 0; lo < N - currSize; lo += currSize * 2) {
                merge(arr, lo, lo + currSize - 1, Math.min(lo + currSize + currSize - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Double a[] = new Double[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }

        sortIteration(a);

        if (SortUtils.isSorted(a)) {
            System.out.println("sort succeeded");

        } else {
            System.out.println("sort failed");

        }
    }
}
