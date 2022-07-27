/**
 * LeetCode552
 * @author yanliu
 * @create 2022-07-26-6:23 PM
 */
public class StudentAttendanceRecordII {
    /**
     * top-down dp solution
     */
    static class Solution1 {
        private final int MOD = 1000000007;

        public int checkRecord(int n) {
            Integer[][][] memo = new Integer[n + 1][2][3];

            return checkRecord(n, 0, 0, memo);
        }

        private int checkRecord(int n, int totalA, int consecutiveL, Integer[][][] memo) {
            if (n == 0) {
                return 1;
            }

            if (memo[n][totalA][consecutiveL] != null) {
                return memo[n][totalA][consecutiveL];
            }

            int res = 0;

            if (totalA < 1) {
                res += checkRecord(n - 1, totalA + 1, 0, memo);
                res %= MOD;
            }

            if (consecutiveL < 2) {
                res += checkRecord(n - 1, totalA, consecutiveL + 1, memo);
                res %= MOD;
            }

            res += checkRecord(n - 1, totalA, 0, memo);
            res %= MOD;

            memo[n][totalA][consecutiveL] = res;

            return res;
        }

    }

}
