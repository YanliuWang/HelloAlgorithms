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

    public static void main(String[] args) {
        System.out.println(new Solution1().knapsack(20, new int[]{14, 8, 7, 5, 3}));
    }
}
