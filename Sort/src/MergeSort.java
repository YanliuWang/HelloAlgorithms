import edu.princeton.cs.algs4.StdRandom;

/**
 * @author yanliu
 * @create 2020-11-28-10:20
 */
public class MergeSort {
    public static void sortRecursion(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        Comparable[] aux = new Comparable[arr.length];

        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        sort(arr, aux, start, mid);
        sort(arr, aux, mid + 1, end);

        // the array is already sorted, we end the recursion
        if (SortUtils.less(arr[mid], arr[mid + 1])) {
            return;
        }

        merge(arr, aux, start, mid, end);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int start, int mid, int end) {
        int leftIdx = start, rightIdx = mid + 1;

        // move all elements in arr to helper
        for (int k = start; k <= end; k++) {
            aux[k] = arr[k];
        }

        // merge
        for (int k = start; k <= end; k++) {
            if (leftIdx > mid) {
                // the left halve elements are all used
                // put the right halve elements to arr
                arr[k] = aux[rightIdx++];

            } else if (rightIdx > end) {
                // the right halve elements are all used
                // put the left halve elements to arr
                arr[k] = aux[leftIdx++];

            } else if (SortUtils.less(aux[rightIdx], aux[leftIdx])) {
                arr[k] = aux[rightIdx++];

            } else {
                // maintain the stability
                arr[k] = aux[leftIdx++];
            }

        }

    }

    /**
     * iterative merge sort
     * from bottom up
     * @param arr
     */
    public static void sortIteration(Comparable[] arr) {
        int N = arr.length;

        Comparable[] aux = new Comparable[N];

        for (int currSize = 1; currSize < N; currSize *= 2) {
            for (int lo = 0; lo < N - currSize; lo += currSize * 2) {
                merge(arr, aux, lo, lo + currSize - 1, Math.min(lo + currSize + currSize - 1, N - 1));
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
    }
}
