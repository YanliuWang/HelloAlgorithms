/**
 * @author yanliu
 * @create 2021-12-20-1:19 PM
 */
public class AlternatingSum {
    static class Solution {
        public static int getSum(int n) {
            int sum = 0;
            boolean isPlus = true;
            int digit = 1;
            int copy = n;

            // get the most digit
            while (copy >= 10) {
                copy /= 10;
                digit *= 10;
            }

            while (n != 0) {
                int top = n / digit;

                if (isPlus) {
                    sum += top;

                } else {
                    sum -= top;
                }

                isPlus = !isPlus;
                n -= top * digit;
                digit /= 10;
            }

            return sum;
        }

        public static void main(String[] args) {
            int n = 12345;
            System.out.println(getSum(n));

        }
    }
}
