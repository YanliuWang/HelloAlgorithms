/**
 * @author yanliu
 * @create 2020-10-31-22:03
 */
public class SortedSquares {
    static class Solution {
        public int[] sortedSquares(int[] A) {
            int n = A.length;

            int[] res = new int[n];

            int left = 0, right = n-1;

            for (int i = n-1; i >= 0; i--) {
                if (Math.abs(A[left]) > Math.abs(A[right])) {
                    res[i] = A[left] * A[left];
                    left++;

                } else {
                    res[i] = A[right] * A[right];
                    right--;

                }

            }

            return res;
        }
    }
}
