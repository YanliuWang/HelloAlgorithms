import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-20-16:32
 */
public class CoinsChange {
    static class Solution1 {
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

        public static void main(String[] args) {
            List<List<Integer>> lists = new Solution1().change(5, new int[]{1, 2, 5});

            for (List<Integer> list : lists) {
                System.out.println(list);
            }
        }
    }
}
