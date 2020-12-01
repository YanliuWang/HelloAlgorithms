package selectionsort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-12-01-18:42
 */
public class SelectionSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (SortUtils.less(arr[j], arr[minIdx])) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                SortUtils.swap(arr, minIdx, i);
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
