/**
 * @author yanliu
 * @create 2021-03-14-15:17
 */
public class Knapsack {
    /**
     * Given a knapsack which can hold s pounds of items,
     * and a set of items with weight w1, w2, ... wn.
     * Return whether we can pick specific items so that their total weight s.
     */
    static class Solution1 {
        public boolean knapsack(int s, int[] weights) {
            if (s <= 0 || weights == null || weights.length == 0) {
                return false;
            }

            return fillKnapsack(s, weights, 0);
        }

        private boolean fillKnapsack(int s, int[] weights, int index) {
            if (s < 0 || s != 0 && index == weights.length) {
                return false;
            }

            if (s == 0) {
                return true;
            }

            return fillKnapsack(s - weights[index], weights, index + 1)
                    || fillKnapsack(s, weights, index + 1);
        }
    }

    static class Solution2 {
        public boolean knapsack(int s, int[] weights) {
            if (s <= 0 || weights == null || weights.length == 0) {
                return false;
            }

            return fillKnapsack(s, weights, 0);
        }

        private boolean fillKnapsack(int s, int[] weights, int index) {
            if (s == 0) {
                return true;
            }

            if (s < 0 || index == weights.length) {
                return false;
            }

            return fillKnapsack(s - weights[index], weights, index + 1)
                    || fillKnapsack(s, weights, index + 1);
        }
    }

    /**
     * 0/1 knapsack problem
     * the s is the capacity
     * maximize the pack weights
     */
    static class Solution3 {
        public int knapsack(int s, int[] weight) {
            if (s <= 0 || weight == null || weight.length == 0) {
                return 0;
            }

            return fillKnapsack(s, weight, 0);
        }

        private int fillKnapsack(int capacity, int[] weight, int index) {
            if (capacity == 0 || index == weight.length) {
                return 0;
            }

            if (weight[index] > capacity) {
                return fillKnapsack(capacity, weight, index + 1);

            }

            return Math.max(fillKnapsack(capacity, weight, index + 1),
                    weight[index] + fillKnapsack(capacity - weight[index], weight, index + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().knapsack(20, new int[]{14, 8, 7, 5, 3}));
    }
}
