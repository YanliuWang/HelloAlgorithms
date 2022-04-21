/**
 * LeetCode768 & 769
 * @author yanliu
 * @create 2022-04-21-12:16 AM
 */
public class MaxChunksToMakeSorted {
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int res = 1;
            int n = arr.length;

            int[] minRight = new int[n];
            minRight[n - 1] = arr[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                minRight[i] = Math.min(arr[i], minRight[i + 1]);
            }

            int maxLeft = 0;

            for (int i = 0; i < n - 1; i++) {
                maxLeft = Math.max(maxLeft, arr[i]);

                if (maxLeft <= minRight[i + 1]) {
                    res++;
                }
            }

            return res;
        }
    }
}
