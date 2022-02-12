/**
 * LeetCode1094
 * @author yanliu
 * @create 2022-02-08-8:55 PM
 */
public class CarPooling {
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] diff = new int[1001];

            for (int[] trip : trips) {
                increaseArray(diff, trip[1], trip[2] - 1, trip[0]);
            }

            int[] res = getRes(diff);

            for (int i = 0; i < res.length; i++) {
                if (res[i] > capacity) {
                    return false;
                }
            }

            return true;
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
