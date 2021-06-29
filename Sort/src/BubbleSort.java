package bubblesort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2021-04-01-17:44
 */
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        StdRandom.shuffle(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (SortUtils.less(arr[j], arr[j - 1])) {
                    SortUtils.swap(arr, j, j - 1);
                }
            }
        }


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
