/**
 * LeetCode829
 * @author yanliu
 * @create 2022-01-03-6:38 PM
 */
public class ConsecutiveSum {
    static class Solution {
        public int consecutiveNumbersSum(int n) {
            int count = 0;
            int UP_BOUND = (int) (Math.sqrt(2 * n + 0.25) - 0.5);

            for (int k = 1; k <= UP_BOUND; k++) {
                if ((n - k * (k + 1) / 2) % k == 0) {
                    count++;
                }
            }

            return count;
        }

    }
}
