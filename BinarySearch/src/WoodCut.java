/**
 * LintCode183
 * @author yanliu
 * @create 2021-10-18-10:54 PM
 */
public class WoodCut {
    static class Solution1 {
        /**
         * @param L: Given n pieces of wood with length L[i]
         * @param k: An integer
         * @return: The maximum length of the small pieces
         */
        public int woodCut(int[] L, int k) {
            // write your code here
            if (L == null || L.length == 0) {
                return 0;
            }

            // we list the range of the wood piece here
            int start = 1, end = 0;
            long sum = 0;
            for (int i = 0; i < L.length; i++) {
                end = Math.max(L[i], end);
                sum += L[i];
            }

            // the max length of the wood is the min value of the max L[i] and sum / k
            end = (int) Math.min(end, sum / k);

            if (end < 1) {
                return 0;
            }

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (getCount(L, mid) >= k) {
                    start = mid;

                } else {
                    end = mid;

                }
            }

            return getCount(L, end) >= k ? end : start;
        }

        private int getCount(int[] L, int len) {
            // get the count of cutted woods with length len
            int count = 0;
            for (int i = 0; i < L.length; i++) {
                count += L[i] / len;
            }

            return count;
        }


    }

    static class Solution2 {
        /**
         * @param l: Given n pieces of wood with length L[i]
         * @param k: An integer
         * @return: The maximum length of the small pieces
         */
        public int woodCut(int[] l, int k) {
            // write your code here
            if (l == null || l.length == 0) {
                return 0;
            }

            // long sum = 0;
            int maxOfWood = 0;

            for (int i = 0; i < l.length; i++) {
                // sum += l[i];
                maxOfWood = Math.max(maxOfWood, l[i]);
            }

            // int start = 1, end = Math.min(sum / k, maxOfWood);
            int start = 1, end = maxOfWood;

            if (end < 1) {
                return 0;
            }

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (canCut(l, mid, k)) {
                    start = mid;

                } else {
                    end = mid - 1;

                }
            }

            if (canCut(l, end, k)) {
                return end;
            }

            if (canCut(l, start, k)) {
                return start;
            }

            return 0;

        }

        private boolean canCut(int[] l, int len, int k) {
            int count = 0;

            for (int currLen : l) {
                count += currLen / len;

                if (count >= k) {
                    return true;
                }
            }

            return false;
        }
    }
}
