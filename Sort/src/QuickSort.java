import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

/**
 * @author yanliu
 * @create 2020-12-02-10:18
 * average time complexity is T(n) = 2T(n / 2) + O(n)
 * worst time complexity is T(n) = T(0) + T(n - 1) + O(n)
 */
public class QuickSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);

    }

    private static void sort(Comparable[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;

        // key point 1 : pivot is the value instead of index
        // we choose the middle value trying to divide the array uniformly
        Comparable pivot = arr[(start + end) / 2];

        // key point 2 : left <= right to avoid endless recursion
        while (left <= right) {
            // arr[left] >= pivot exit while loop
            while (left <= right && SortUtils.less(arr[left], pivot)){
                left++;
            }

            // arr[right] <= pivot exit while loop
            while (left <= right && SortUtils.less(pivot, arr[right])) {
                right--;
            }

            // swap the arr[left] and arr[right]
            if (left <= right) {
                SortUtils.swap(arr, left, right);
                left++;
                right--;
            }

        }

        sort(arr, start, right);
        sort(arr, left, end);

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

    public class Solution {
        /**
         * @param A: an integer array
         * @return: nothing
         */
        public void sortIntegers2(int[] A) {
            // write your code here
            if (A == null || A.length < 2) {
                return;
            }

            quickSort(A, 0, A.length - 1);
        }

        private void quickSort(int[] A, int start, int end) {
            if (start >= end) {
                return;
            }

            int left = start, right = end;

            // 1. select the middle number as the pivot
            int pivot = A[start + (end - start) / 2];

            // 2. left <= right not left < right
            while (left <= right) {
                // 3. A[left] < pivot not <=
                while (left <= right && A[left] < pivot) {
                    left++;
                }

                while (left <= right && A[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    swap(A, left, right);
                    left++;
                    right--;
                }
            }

            quickSort(A, start, right);
            quickSort(A, left, end);
        }

        private void swap(int[] A, int index1, int index2) {
            int temp = A[index1];
            A[index1] = A[index2];
            A[index2] = temp;
        }
    }
}
