/**
 * Leetcode 9
 * @author yanliu
 * @create 2021-11-27-7:50 PM
 */
public class PalindromeNumber {
    static class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }

            int reverse = 0;

            while (x > reverse) {
                int digit = x % 10;
                reverse = reverse * 10 + digit;
                x = x / 10;
            }

            return reverse == x || x == reverse / 10;
        }
    }

    static class Solution2 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int copy = x;
            int res = 0;

            while (x != 0) {
                int bit = x % 10;

                if (res > Integer.MAX_VALUE / 10
                        || (res == Integer.MAX_VALUE / 10
                        && bit == Integer.MAX_VALUE % 10)) {
                    return false;
                }

                res = res * 10 + bit;
                x = x / 10;
            }

            return res == copy;


        }
    }
}
