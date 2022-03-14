/**
 * LeetCode338
 * @author yanliu
 * @create 2022-03-01-9:58 AM
 */
public class CountingBits {
    static class Solution1 {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                ans[i] = popCount(i);

            }

            return ans;
        }

        private int popCount(int n) {
            int count = 0;

            while (n != 0) {
                n &= n - 1;
                count++;
            }

            return count;
        }
    }

    static class Solution2 {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];

            for (int x = 1; x <= n; x++) {
                ans[x] = ans[x & (x - 1)] + 1;
            }

            return ans;
        }
    }
}
