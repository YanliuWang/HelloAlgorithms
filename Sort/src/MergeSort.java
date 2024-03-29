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

    public class Solution {
        /**
         * @param A: an integer array
         * @return: nothing
         */
        public void sortIntegers(int[] A) {
            // write your code here
            if (A == null || A.length < 2) {
                return;
            }

            int[] temp = new int[A.length];
            mergeSort(A, 0, A.length - 1, temp);
        }

        // 1. 递归的定义：对 A 元素从 start 到 end 进行排序
        private void mergeSort(int[] A, int start, int end, int[] temp) {
            // 2. 递归的出口: A 中元素要么为 0 个，要么为 1 个，退出
            if (start >= end) {
                return;
            }

            // 3. 递归的拆解
            int mid = start + (end - start) / 2;
            mergeSort(A, start, mid, temp);
            mergeSort(A, mid + 1, end, temp);

            // the left and right parts do not need to be merged
            if (A[mid] < A[mid + 1]) {
                return;
            }

            merge(A, start, mid, end, temp);
        }

        private void merge(int[] A, int start, int mid, int end, int[] temp) {
            int leftStart = start, rightStart = mid + 1;
            int index = start;

            while (leftStart <= mid && rightStart <= end) {
                if (A[leftStart] <= A[rightStart]) {
                    temp[index++] = A[leftStart++];

                } else {
                    temp[index++] = A[rightStart++];

                }
            }

            while (leftStart <= mid) {
                temp[index++] = A[leftStart++];
            }

            while (rightStart <= end) {
                temp[index++] = A[rightStart++];
            }

            for (int i = start; i <= end; i++) {
                A[i] = temp[i];
            }
        }
    }
}
