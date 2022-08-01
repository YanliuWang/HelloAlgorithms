import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-10:56 AM
 */
public class MaxAverageStock {
    static class Solution1 {
        public int maxPrice(int[] prices, int k) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            // using set as sliding window
            Set<Integer> window = new HashSet<>();
            int maxPrice = 0;
            int left = 0, right = 0;
            int currSum = 0;

            while (right < prices.length) {
                while (right < prices.length && window.size() < k) {
                    // shrink the window
                    if (window.contains(prices[right])) {
                        window.remove(prices[left]);
                        currSum -= prices[left];
                        left++;

                    } else {
                        // extend the window
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

            return maxPrice == 0 ? -1 : maxPrice;

        }
    }

    static class Solution2 {
        public int getMaxSum(int[] prices, int k) {
            if (prices == null || prices.length == 0 || k <= 0) {
                return 0;
            }

            Set<Integer> window = new HashSet<>();
            int left = 0, right = 0;
            int maxSum = 0;
            int currSum = 0;

            while (right < prices.length) {
                while (right < prices.length && window.size() < k) {
                    // shrink the window
                    if (window.contains(prices[right])) {
                        window.remove(prices[left]);
                        currSum -= prices[left];
                        left++;

                    } else {
                        // extend the window
                        window.add(prices[right]);
                        currSum += prices[right];
                        right++;

                    }
                }

                if (window.size() < k) {
                    break;
                }

                maxSum = Math.max(maxSum, currSum);

                window.remove(prices[left]);

                currSum -= prices[left];
                left++;
            }

            return maxSum == 0 ? -1 : maxSum;

        }
    }

    static class Solution3 {
        // max stock price
        public int maxPrice(int[] prices, int k) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            Set<Integer> window = new HashSet<>();
            Map<Integer, Integer> numToIdx = new HashMap<>();
            int maxPrice = 0;
            int left = 0, right = 0;
            int currSum = 0;

            while (right < prices.length) {
                while (right < prices.length && window.size() < k) {
                    // shrink the window
                    if (window.contains(prices[right])) {
                        // move to next non-duplicate position
                        int nextLeft = numToIdx.get(prices[right]) + 1;

                        while (left < nextLeft) {
                            window.remove(prices[left]);
                            numToIdx.remove(prices[left]);
                            currSum -= prices[left];
                            left++;
                        }

                    } else {
                        // extend the window
                        window.add(prices[right]);
                        currSum += prices[right];
                        numToIdx.put(prices[right], right);
                        right++;
                    }
                }

                // update the sum of window
                if (window.size() == k) {
                    maxPrice = Math.max(maxPrice, currSum);
                    window.remove(prices[left]);
                    numToIdx.remove(prices[left]);
                    currSum -= prices[left];
                    left++;
                }
            }

            return maxPrice == 0 ? -1 : maxPrice;

        }
    }

    public int maxOfArray(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    public int minOfArray(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }

        return min;
    }


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] arr1 = {1, 2, 7, 7, 4, 3, 6};
        int[] arr2 = {4, 1, 2, 4, 4};

        System.out.println(solution.maxPrice(arr2, 4));
    }
}
