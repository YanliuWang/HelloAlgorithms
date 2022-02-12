/**
 * LeetCode231
 * @author yanliu
 * @create 2021-12-16-10:30 AM
 */
public class PowerOfTwo {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }

            // get the last one bit
            // remove the last one bit
            // minus the removed value
            n -= n & (-n);

            return n == 0;
        }
    }
}
