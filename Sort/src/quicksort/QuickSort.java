package quicksort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-12-02-10:18
 */
public class QuickSort {
//    public static void sort(Comparable[] arr) {
//        StdRandom.shuffle(arr);
//
//        sort(arr, 0, arr.length - 1);
//    }
//
//    private static void sort(Comparable[] arr, int lo, int hi) {
//        if (hi <= lo) {
//            return;
//        }
//
//        int j = partition(arr, lo, hi);
//        sort(arr, lo, j - 1);
//        sort(arr, j + 1, hi);
//    }
//
//    private static int partition(Comparable[] arr, int lo, int hi) {
//        int i = lo, j = hi + 1;
//        Comparable v = arr[lo];
//
//        while (true) {
//            while (SortUtils.less(arr[++i], v)) {
//                if (i == hi) {
//                    break;
//                }
//            }
//
//            while (SortUtils.less(v, arr[--j])) {
//                if (j == lo) {
//                    break;
//                }
//            }
//
//            if (i >= j) {
//                break;
//            }
//
//            SortUtils.swap(arr, i, j);
//        }
//
//        SortUtils.swap(arr, lo, j);
//
//        return j;
//    }
//
    public static void main(String[] args) {
        Integer[] a = new Integer[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        sort(a);

        if (SortUtils.isSorted(a)) {
            System.out.println("sort succeeded");

        } else {
            System.out.println("sort failed");

        }

        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        Comparable pivot = arr[lo];
        int i = lo + 1, j = hi;

        while (i <= j) {
            while (i <= j && SortUtils.less(arr[i], pivot)) {
                i++;
            }

            while (i <= j && SortUtils.less(pivot, arr[j])) {
                j--;
            }

            if (i <= j) {
                SortUtils.swap(arr, i, j);
                i++;
                j--;
            }

        }

        SortUtils.swap(arr, lo, j);

        return j;

    }
}
