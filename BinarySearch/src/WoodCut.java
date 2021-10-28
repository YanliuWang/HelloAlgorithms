/**
 * @author yanliu
 * @create 2021-10-18-10:54 PM
 */
public class WoodCut {
    class Solution {
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
}
