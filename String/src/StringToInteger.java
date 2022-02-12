/**
 * LeetCode8
 * @author yanliu
 * @create 2021-12-30-11:17 AM
 */
public class StringToInteger {
    class Solution {
        public int myAtoi(String s) {
            // discard all whitespaces
            int index = 0;
            int sign = 1;
            int res = 0;
            int len = s.length();

            while (index < len && s.charAt(index) == ' ') {
                index++;
            }

            if (index < len && s.charAt(index) == '-') {
                sign = -1;
                index++;

            } else if (index < len && s.charAt(index) == '+') {
                sign = 1;
                index++;
            }

            while (index < len && isDigit(s.charAt(index))) {
                int digit = s.charAt(index) - '0';

                if (res > Integer.MAX_VALUE / 10
                        || (res == Integer.MAX_VALUE / 10
                        && digit > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                res = res * 10 + digit;
                index++;
            }

            return sign * res;
        }

        private boolean isDigit(char ch) {
            return ch >= '0' && ch <= '9';
        }
    }
}
