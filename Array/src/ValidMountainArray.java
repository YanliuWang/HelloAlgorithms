/**
 * @author yanliu
 * @create 2020-10-30-16:24
 */
public class ValidMountainArray {
    static class Solution {
        public boolean validMountainArray(int[] A) {
            int i = 1;

            while (i < A.length && A[i-1] < A[i]) {
                i++;
            }

            if (i == 1 || i == A.length) {
                return false;
            }

            while (i < A.length && A[i-1] > A[i]) {
                i++;
            }

            return i == A.length;
        }
    }
}
