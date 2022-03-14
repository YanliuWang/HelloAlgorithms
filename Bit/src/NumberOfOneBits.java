/**
 * LeetCode191
 * @author yanliu
 * @create 2021-12-16-10:35 AM
 */
public class NumberOfOneBits {
    static class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;

            while (n != 0) {
                res++;
                // make the last '1' in n become '0'
                n = n & (n - 1);
            }

            return res;

        }
    }

    static class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int mask = 1;
            int bits = 0;

            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }

                mask <<= 1;
            }

            return bits;
        }
    }
}
