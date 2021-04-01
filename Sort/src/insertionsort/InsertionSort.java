package insertionsort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-11-29-17:23
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        for (int i = 1; i < N; i++) {
            Comparable key = arr[i];
            int j;

            for (j = i - 1; j >= 0 && SortUtils.less(key, arr[j]); j--) {
                arr[j + 1] = arr[j];

            }

            arr[j + 1] = key;
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

    // search for the right index to insert the element
    // we have no idea about whether there is left or right bound
//    private static int binarySearchIndex(Comparable[] arr, int left, int right, Comparable key) {
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//
//            if (SortUtils.less(arr[mid], key)) {
//                right = mid - 1;
//            } else if (SortUtils.less(key, arr[mid]) {
//                left = mid + 1;
//            }
//
//        }
//    }

}
