package selectionsort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-12-01-18:42
 */
@SuppressWarnings("rawtypes")
public class SelectionSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        StdRandom.shuffle(arr);

        int N = arr.length;

        // store the index of global min value
        int globalMin = 0;

        for (int i = 0; i < N - 1; i++) {
            globalMin = i;

            // find the minimum index
            for (int j = i + 1; j < N; j++) {
                if (SortUtils.less(arr[j], arr[globalMin])) {
                    globalMin = j;
                }
            }

            if (globalMin != i) {
                SortUtils.swap(arr, globalMin, i);
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
