package shellsort;

import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtils;

/**
 * @author yanliu
 * @create 2020-12-01-21:33
 */
public class ShellSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int h = 1;
        int N = arr.length;

        while (h < 3 / N) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                Comparable key = arr[i];

                int j;

                for (j = i - h; j >= 0 && SortUtils.less(key, arr[j]); j -= h) {
                    arr[j + h] = arr[j];
                }

                arr[j + h] = key;
            }

            h = h / 3;
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
