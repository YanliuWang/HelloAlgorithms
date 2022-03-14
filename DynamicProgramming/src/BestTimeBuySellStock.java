/**
 * @author yanliu
 * @create 2022-03-06-6:05 PM
 */
public class BestTimeBuySellStock {
    /**
     * LeetCode121
     */
    static class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

            for (int i = 0; i < prices.length; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }

            return dp_i_0;
        }
    }
}
