/**
 * https://www.algoexpert.io/questions/subarray-sort
 * @author yanliu
 * @create 2022-06-22-6:14 PM
 */
public class SubarraySort {
    static class Solution {
        public static int[] subarraySort(int[] array) {
            // Write your code here.
            int minOutOrder = Integer.MAX_VALUE;
            int maxOutOrder = Integer.MIN_VALUE;

            for (int i = 0; i < array.length; i++) {
                int num = array[i];

                if (isOutofOrder(i, num, array)) {
                    minOutOrder = Math.min(minOutOrder, num);
                    maxOutOrder = Math.max(maxOutOrder, num);
                }
            }

            if (minOutOrder == Integer.MAX_VALUE && maxOutOrder == Integer.MIN_VALUE) {
                return new int[]{-1, -1};
            }

            int start = 0;
            while (array[start] <= minOutOrder) {
                start++;
            }

            int end = array.length - 1;
            while (array[end] >= maxOutOrder) {
                end--;
            }

            return new int[]{start, end};
        }

        private static boolean isOutofOrder(int idx, int num, int[] array) {
            if (idx == 0) {
                return num > array[idx + 1];
            }

            if (idx == array.length - 1) {
                return num < array[idx - 1];
            }

            return num < array[idx - 1] || num > array[idx + 1];
        }
    }

}
