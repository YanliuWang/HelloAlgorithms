/**
 * LeetCode 7
 * @author yanliu
 * @create 2021-11-24-9:16 AM
 */
public class ReverseInteger {
    static class Solution {
        public int reverse(int x) {
            int rev = 0, digit = 0;

            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }

                digit = x % 10;
                rev = rev * 10 + digit;
                x = x / 10;
            }

            return rev;
        }
    }
}
