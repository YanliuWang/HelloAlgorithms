/**
 * LeetCode7
 * @author yanliu
 * @create 2022-03-05-11:50 PM
 */
public class ReverseInteger {
    static class Solution {
        public int reverse(int x) {
            int res = 0;
            int digit = 0;

            while (x != 0) {
                if (res > Integer.MAX_VALUE / 10
                        || res < Integer.MIN_VALUE / 10) {
                    return 0;
                }

                digit = x % 10;
                res = res * 10 + digit;

                x /= 10;
            }

            return res;
        }
    }
}
