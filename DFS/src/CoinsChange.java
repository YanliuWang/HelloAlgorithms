import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-20-16:32
 */
public class CoinsChange {
    /**
     * LeetCode322
     */
    static class Solution1 {
        private int min = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }

            Arrays.sort(coins);

            dfs(coins, coins.length - 1, 0, amount);

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        private boolean dfs(int[] coins, int index, int count, int remain) {
            if (remain == 0) {
                if (count < min) {
                    min = count;
                }

                return true;
            }

            if (index < 0 || remain < 0) {
                return false;
            }

            if (count >= min) {
                return false;
            }

            boolean res = false;

            for (int i = remain / coins[index]; i >= 0; i--) {
                if (dfs(coins, index - 1, count + i, remain - i * coins[index])) {
                    res = true;
                }
            }

            return res;
        }
    }

    /**
     * LeetCode322
     */
    static class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }

            int[] dp = new int[amount + 1];

            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }


    static class Solution3 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> change(int amount, int[] coins) {
            if (coins == null || coins.length == 0) {
                return null;
            }

            Arrays.sort(coins);

            int[] sol = new int[coins.length];

            dfs(coins, amount, coins.length - 1, sol);

            return res;
        }

        private void dfs(int[] coins, int remain, int level, int[] sol) {
            if (remain == 0) {
                res.add(buildToList(sol));
                return;
            }

            if (level < 0 || remain < 0) {
                return;
            }

            for (int i = remain / coins[level]; i >= 0; i--) {
                sol[level] = i;
                dfs(coins, remain - i * coins[level], level - 1, sol);
            }
        }

        private List<Integer> buildToList(int[] array) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                res.add(array[i]);
            }

            return res;
        }
    }
}
