/**
 * LeetCode1109
 * @author yanliu
 * @create 2022-02-08-8:38 PM
 */
public class CorporateFlightBookings {
    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] diff = new int[n];

            for (int[] booking : bookings) {
                increaseArray(diff, booking[0] - 1, booking[1] - 1, booking[2]);
            }

            int[] res = getRes(diff);

            return res;
        }

        private void increaseArray(int[] diff, int i, int j, int val) {
            diff[i] += val;

            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        private int[] getRes(int[] diff) {
            int[] res = new int[diff.length];

            res[0] = diff[0];

            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }
    }
}
