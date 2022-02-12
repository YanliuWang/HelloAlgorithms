/**
 * LeetCode1011
 * @author yanliu
 * @create 2022-02-09-4:48 PM
 */
public class CapacityToShipPackagesWithinDays {
    static class Solution1 {
        public int shipWithinDays(int[] weights, int days) {
            int l = 1;
            int r = 0;

            for (int i = 0; i < weights.length; i++) {
                l = Math.max(l, weights[i]);
                r += weights[i];
            }

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (canShip(mid, weights, days)) {
                    r = mid;

                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

        private boolean canShip(int capacity, int[] weights, int days) {
            int d = 0;
            int i = 0;

            while (i < weights.length) {
                int sum = 0;

                while (i < weights.length) {
                    if (sum + weights[i] > capacity) {
                        break;

                    } else {
                        sum += weights[i];
                        i++;
                    }
                }

                d++;
            }

            return d <= days;
        }
    }

    static class Solution2 {
        public int shipWithinDays(int[] weights, int days) {
            int l = 1;
            int r = 0;

            for (int i = 0; i < weights.length; i++) {
                l = Math.max(l, weights[i]);
                r += weights[i];
            }

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (canShip(mid, weights, days)) {
                    r = mid;

                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

        private boolean canShip(int capacity, int[] weights, int days) {
            int i = 0, d = 0;

            while (i < weights.length) {
                int cap = capacity;

                while (i < weights.length) {
                    if (cap < weights[i]) {
                        break;

                    } else {
                        cap -= weights[i];
                        i++;
                    }

                }

                d++;
            }

            return d <= days;
        }
    }
}
