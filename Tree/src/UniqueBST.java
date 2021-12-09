/**
 * LeetCode 96
 * @author yanliu
 * @create 2021-11-11-11:14 AM
 */
public class UniqueBST {
    static class Solution {
        public int numTrees(int n) {
            int[][] memo = new int[n + 1][n + 1];

            return count(1, n, memo);
        }

        private int count(int lo, int hi, int[][] memo) {
            if (lo > hi) {
                return 1;
            }

            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }

            int res = 0;
            for (int mid = lo; mid <= hi; mid++) {
                int left = count(lo, mid - 1, memo);
                int right = count(mid + 1, hi, memo);
                res += left * right;
            }

            memo[lo][hi] = res;

            return res;
        }
    }
}
