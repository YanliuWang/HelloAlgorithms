/**
 * LeetCode370
 * @author yanliu
 * @create 2021-12-15-5:50 PM
 */
public class RangeAddition {
    static class Solution {
        /**
         * using diff array to solve this kind of problem
         * @param length
         * @param updates
         * @return
         */
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] diff = new int[length];

            for (int[] update : updates) {
                increaseArray(diff, update[0], update[1], update[2]);
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
