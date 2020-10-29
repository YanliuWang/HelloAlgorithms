/**
 * @author yanliu
 * @create 2020-10-29-10:09
 */
public class DuplicateZeros {
    static class Solution {
        public void duplicateZeros(int[] arr) {
            int countZero = 0;

            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == 0) {
                    countZero++;
                }
            }

            int i = arr.length-1, j = arr.length+countZero-1;

            // i == j means duplication is finished
            while (i < j) {
                if (arr[i] != 0) {
                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }
                } else {
                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }

                    j--;

                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }
                }
            }
        }
    }
}
