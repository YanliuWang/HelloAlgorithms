import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are an amazon delivery and you have some boxes that you have to deliver, but there are some conditions -
 *
 * You can take 2 boxes of same weight in one round
 * you can take 3 boxes of same weight in one round
 * You have to find the minimum number of rounds to deliver the boxes or -1 if it is not possible to deliver them.
 *
 * Example cases -
 * Input: boxes - [2, 2, 3, 3, 2, 4, 4, 4, 4, 4]
 * Output: 4
 * Explanation: 3 boxes of weight 2 in 1st round, 2 boxes of weight 3 in 2nd round, 3 boxes of wt 4 in 3rd and 2 boxes of wt 4 in 4th round.
 *
 * Input: boxes - [2, 3, 3]
 * Output: -1
 * Explanation: There is only one box with weight 2 and we can only take either 2 or 3 boxes in one round not lesser.
 * @author yanliu
 * @create 2022-07-25-1:06 AM
 */
public class AmazonDelivery {
    static class Solution {
        public int getRounds(int[] boxes) {
            if (boxes == null || boxes.length == 0) {
                return 0;
            }

            Map<Integer, Integer> weightToCnt = new HashMap<>();
            for (int box : boxes) {
                weightToCnt.put(box, weightToCnt.getOrDefault(box, 0) + 1);
            }

            int rounds = 0;

            for (int key : weightToCnt.keySet()) {
                int cnt = weightToCnt.get(key);

                if (cnt == 1) {
                    return -1;
                }

                int round = getRound(cnt);

                if (round == -1) {
                    return -1;
                }

                rounds += round;
            }

            return rounds;
        }

        private int getRound(int amount) {
            int[] dp = new int[amount + 1];
            int[] coins = new int[]{2, 3};

            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] arr2 = new int[]{2, 3, 3};
        System.out.println(solution.getRounds(arr2));
    }
}
