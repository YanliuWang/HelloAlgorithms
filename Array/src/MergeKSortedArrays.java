/**
 * LintCode486
 * @author yanliu
 * @create 2022-05-13-10:01 AM
 */
public class MergeKSortedArrays {
    class Solution {
        /**
         * @param arrays: k sorted integer arrays
         * @return: a sorted array
         */
        public int[] mergeKSortedArrays(int[][] arrays) {
            // write your code here
            if (arrays == null || arrays.length == 0
                    || arrays[0] == null || arrays[0].length == 0) {
                return new int[0];
            }

            return mergeKSortedArrays(arrays, 0, arrays.length - 1);
        }

        private int[] mergeKSortedArrays(int[][] arrays, int start, int end) {
            if (start == end) {
                return arrays[start];
            }

            int mid = start + (end - start) / 2;
            int[] left = mergeKSortedArrays(arrays, start, mid);
            int[] right = mergeKSortedArrays(arrays, mid + 1, end);

            return mergeTwoSortedArray(left, right);
        }

        private int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
            if (arr1 == null) {
                return arr2;
            }

            if (arr2 == null) {
                return arr1;
            }

            int n = arr1.length + arr2.length;
            int[] arr = new int[n];
            int p = 0;
            int p1 = 0, p2 = 0;

            while (p1 < arr1.length && p2 < arr2.length) {
                if (arr1[p1] < arr2[p2]) {
                    arr[p++] = arr1[p1++];

                } else {
                    arr[p++] = arr2[p2++];

                }

            }

            while (p1 < arr1.length) {
                arr[p++] = arr1[p1++];
            }

            while (p2 < arr2.length) {
                arr[p++] = arr2[p2++];
            }

            return arr;
        }
    }
}
