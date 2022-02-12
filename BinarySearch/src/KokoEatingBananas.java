/**
 * LeetCode875
 * @author yanliu
 * @create 2022-02-09-4:19 PM
 */
public class KokoEatingBananas {
    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = 1000000000 + 1;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (canEat(mid, piles, h)) {
                    r = mid;

                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

        private boolean canEat(int k, int[] piles, int h) {
            int hours = 0;

            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / k;

                if (piles[i] % k > 0) {
                    hours++;
                }
            }

            return hours <= h;
        }
    }
}
