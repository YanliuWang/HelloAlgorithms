/**
 * @author yanliu
 * @create 2022-02-18-6:56 PM
 */
public class MyPow {
    static class Solution1 {
        public double myPow(double x, int n) {
            if (x == 1.0 || n == 0) {
                return 1.0;
            }

            if (n < 0) {
                return 1 / x * myPow(1 / x, - (n + 1));

            }

            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

        }
    }

    static class Solution2 {
        public double myPow(double x, int n) {
            if (x == 1.0 || n == 0) {
                return 1.0;
            }

            double res = 1.0;

            for (int i = n; i != 0; i /= 2) {
                if (i % 2 != 0) {
                    res *= x;
                }

                x *= x;
            }

            return n < 0 ? 1 / res : res;
        }
    }
}
