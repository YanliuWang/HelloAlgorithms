import java.util.HashMap;
import java.util.Map;

/**
 * lintcode 976
 * @author yanliu
 * @create 2021-10-23-11:01 PM
 */
public class FourSum {
    public class Solution {
        /**
         * @param A: a list
         * @param B: a list
         * @param C: a list
         * @param D: a list
         * @return: how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero
         */
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            // Write your code here
            int count = 0;
            Map<Integer, Integer> sumToFreq = new HashMap<>();

            for (Integer a : A) {
                for (Integer b : B) {
                    int sum = a + b;
                    sumToFreq.put(sum, sumToFreq.getOrDefault(sum, 0) + 1);
                }
            }

            for (Integer c : C) {
                for (Integer d : D) {
                    int sum = c + d;
                    count += sumToFreq.getOrDefault(-sum, 0);
                }
            }

            return count;
        }
    }
}
