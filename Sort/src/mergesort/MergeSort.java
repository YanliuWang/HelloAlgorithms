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
        Comparable[] help = new Comparable[right - left + 1];

        int i = 0, j = left, k = mid + 1;

        while (j <= mid && k <= right) {
            help[i++] = SortUtils.less(arr[j], arr[k]) ? arr[j++] : arr[k++];
        }

        while (j <= mid) {
            help[i++] = arr[j++];
        }

        while (k <= right) {
            help[i++] = arr[k++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

    }

    public static void sortIteration(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = 0, right = arr.length - 1;

        for (int currSize = 1; currSize <= right - left; currSize *= 2) {
            for (int i = left; i < right; i = i + currSize * 2) {
                int from = i;
                int mid = Math.min(i + currSize - 1, right);
                int to = Math.min(mid + currSize, right);

                merge(arr, from, mid, to);
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
