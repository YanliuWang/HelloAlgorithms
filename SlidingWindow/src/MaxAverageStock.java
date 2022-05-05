import java.util.HashSet;
import java.util.Set;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-10:56 AM
 */
public class MaxAverageStock {
    static class Solution {
        public int maxPrice(int[] prices, int k) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            Set<Integer> window = new HashSet<>();
            int maxPrice = 0;
            int left = 0, right = 0;
            int currSum = 0;

            while (right < prices.length) {
                while (right < prices.length && window.size() < k) {
                    if (window.contains(prices[right])) {
                        window.remove(prices[left]);
                        currSum -= prices[left];
                        left++;

                    } else {
                        window.add(prices[right]);
                        currSum += prices[right];
                        right++;
                    }
                }

                maxPrice = Math.max(maxPrice, currSum);

                window.remove(prices[left]);
                currSum -= prices[left];
                left++;
            }

            return maxPrice;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 7, 7, 4, 3, 6};
        int[] arr2 = {1, 2, 4, 3};

        System.out.println(solution.maxPrice(arr2, 2));
    }
}
