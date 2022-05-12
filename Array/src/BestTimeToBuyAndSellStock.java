/**
 * LeetCode121
 * @author yanliu
 * @create 2021-12-07-11:13 AM
 */
public class BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }

                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }

            return maxProfit;
        }
    }
}
