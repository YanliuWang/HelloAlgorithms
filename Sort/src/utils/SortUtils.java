package utils;


import java.util.Arrays;

/**
 * @author yanliu
 * @create 2020-11-27-17:10
 */
public class SortUtils {
    public static boolean less(Comparable o1, Comparable o2) {
        return (o1.compareTo(o2) < 0);
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i-1])) {
                return false;
            }
        }

        return true;

    }
}
