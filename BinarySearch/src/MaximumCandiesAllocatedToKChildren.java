/**
 * LeetCode2226
 * @author yanliu
 * @create 2022-04-02-10:54 PM
 */
public class MaximumCandiesAllocatedToKChildren {
    static class Solution {
        public int maximumCandies(int[] candies, long k) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < candies.length; i++) {
                max = Math.max(max, candies[i]);
            }


            int left = 0, right = max;
            long subPiles = 0;

            while (left + 1 < right) {
                int pile = left + (right - left) / 2 + 1;

                subPiles = 0;

                for (int i = 0; i < candies.length; i++) {
                    subPiles += candies[i] / pile;
                }

                if (subPiles >= k) {
                    left = pile;

                } else {
                    right = pile - 1;

                }

            }

            subPiles = 0;
            for (int i = 0; i < candies.length; i++) {
                subPiles += candies[i] / right;
            }

            if (subPiles >= k) {
                return right;
            }

            return left;

        }
    }
}
