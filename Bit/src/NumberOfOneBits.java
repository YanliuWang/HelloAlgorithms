/**
 * LeetCode191
 * @author yanliu
 * @create 2021-12-16-10:35 AM
 */
public class NumberOfOneBits {
    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;

            while (n != 0) {
                res++;
                // remove the last '1'
                n = n & (n - 1);
            }

            return res;

        }
    }
}
