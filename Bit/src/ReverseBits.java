/**
 * LeetCode190
 * @author yanliu
 * @create 2021-12-16-10:51 AM
 */
public class ReverseBits {
    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;

            for (int i = 0; i < 32; i++) {
                // prep room for current potential '1' placement
                res <<= 1;

                // if the last bit of n is '1'
                // increase the res to make the last bit to '1'
                if ((n & 1) == 1) {
                    res++;
                }

                n >>= 1;
            }

            return res;
        }
    }
}
