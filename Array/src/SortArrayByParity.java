/**
 * @author yanliu
 * @create 2020-10-31-20:37
 */
public class SortArrayByParity {
    static class Solution {
        public int[] sortArrayByParity(int[] A) {
            if (A == null || A.length == 0) {
                return A;
            }

            int start = 0, end = A.length - 1;

            while (start < end) {
                if (A[start] % 2 == 0) {
                    start++;

                } else {
                    if (A[end] % 2 != 0) {
                        end--;

                    }

                    if (A[end] % 2 == 0) {
                        swap(A, start, end);
                        start++;
                        end--;
                    }
                }
            }

            return A;
        }

        private void swap(int[] A, int i, int j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;

        }

    }
}
