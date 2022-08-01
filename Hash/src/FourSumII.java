import java.util.HashMap;
import java.util.Map;

/**
 * LintCode976
 * @author yanliu
 * @create 2022-08-01-1:01 PM
 */
public class FourSumII {
    static class Solution {
        /**
         * @param a: a list
         * @param b: a list
         * @param c: a list
         * @param d: a list
         * @return: how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero
         */
        public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
            // Write your code here
            int n = a.length;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = a[i] + b[j];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int target = -(c[i] + d[j]);

                    res += map.getOrDefault(target, 0);
                }
            }

            return res;

        }
    }
}
