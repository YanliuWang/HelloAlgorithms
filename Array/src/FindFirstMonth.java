/**
 * Amazon OA
 * @author yanliu
 * @create 2022-08-13-2:38 PM
 */
public class FindFirstMonth {
    static class Solution {
        public int findFirstMonth(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int change = Integer.MAX_VALUE;
            int month = 0;
            int n = prices.length;
            int[] prefixSum = getPrefixSum(prices);

            for (int i = 1; i < n; i++) {
                int left = prefixSum[i] / i;
                int right = (prefixSum[n] - prefixSum[i]) / (n - i);

                if (Math.abs(left - right) < change) {
                    change = Math.abs(left - right);
                    month = i;
                }

            }

            return month;
        }

        private int[] getPrefixSum(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n + 1];

            prefixSum[0] = 0;

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            return prefixSum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 2, 4, 5};

        System.out.println(solution.findFirstMonth(arr));
    }
}
