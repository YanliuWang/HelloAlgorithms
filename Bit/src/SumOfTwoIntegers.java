/**
 * LeetCode371
 * @author yanliu
 * @create 2022-03-10-10:13 AM
 */
public class SumOfTwoIntegers {
    class Solution {
        public int getSum(int a, int b) {
            int x = Math.abs(a);
            int y = Math.abs(b);

            if (x < y) {
                return getSum(b, a);
            }

            int sign = a > 0 ? 1 : -1;

            if (a * b >= 0) {
                int ans = 0;
                int carry = 0;

                while (y != 0) {
                    ans = x ^ y;
                    carry = (x & y) << 1;
                    x = ans;
                    y = carry;

                }

            } else {
                int ans = 0;
                int borrow = 0;

                while (y != 0) {
                    ans = x ^ y;
                    borrow = ((~x) & y) << 1;
                    x = ans;
                    y = borrow;
                }

            }

            return sign * x;
        }
    }
}
