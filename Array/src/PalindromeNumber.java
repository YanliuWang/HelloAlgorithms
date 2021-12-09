/**
 * Leetcode 9
 * @author yanliu
 * @create 2021-11-27-7:50 PM
 */
public class PalindromeNumber {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }

            int reverted = 0;

            while (x > reverted) {
                int digit = x % 10;
                reverted = reverted * 10 + digit;
                x = x / 10;
            }

            return reverted == x || x == reverted / 10;
        }
    }
}
