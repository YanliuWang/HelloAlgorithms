import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode2055
 * @author yanliu
 * @create 2021-12-15-4:49 PM
 */
public class PlatesBetweenCandles {
    static class Solution1 {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            List<Integer> candleIndices = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '|') {
                    candleIndices.add(i);
                }
            }

            if (candleIndices.size() == 0) {
                return new int[queries.length];
            }

            int[] res = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                // the first greater or equal to queries[i][0] candle index
                int start = firstGreaterOrEqual(candleIndices, queries[i][0]);
                // the first less or equal to queries[i][1] cancle index
                int end = firstGreater(candleIndices, queries[i][1]) - 1;

                if (start == -1 || start >= end) {
                    res[i] = 0;

                } else {
                    res[i] = candleIndices.get(end) - candleIndices.get(start) - (end - start);
                }

            }

            return res;


        }

        private int firstGreaterOrEqual(List<Integer> list, int target) {
            int start = 0, end = list.size() - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (list.get(mid) >= target) {
                    end = mid;

                } else {
                    start = mid + 1;
                }
            }

            if (list.get(start) >= target) {
                return start;
            }

            if (list.get(end) >= target) {
                return end;
            }

            return -1;
        }

        private int firstGreater(List<Integer> list, int target) {
            int start = 0, end = list.size() - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (list.get(mid) <= target) {
                    start = mid + 1;

                } else {
                    end = mid;
                }
            }

            if (list.get(start) > target) {
                return start;
            }

            if (list.get(end) > target) {
                return end;
            }

            return end + 1;
        }
    }

    static class Solution2 {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int n = s.length();
            int[] nearestLeftCandle = new int[n];
            int[] nearestRightCandle = new int[n];
            int[] candleCount = new int[n];
            int[] res = new int[queries.length];

            int candle = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '|') {
                    candle = i;
                }

                nearestLeftCandle[i] = candle;
            }

            candle = n;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    candle = i;
                }

                nearestRightCandle[i] = candle;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '|') {
                    count++;
                }

                candleCount[i] = count;
            }

            for (int i = 0; i < queries.length; i++) {
                int left = queries[i][0];
                int right = queries[i][1];

                int leftCandle = nearestRightCandle[left];
                int rightCandle = nearestLeftCandle[right];

                if (left == -1 || right == n) {
                    res[i] = 0;
                    continue;
                }

                int distance = rightCandle - leftCandle;

                if (distance <= 1) {
                    res[i] = 0;
                    continue;
                }

                res[i] = rightCandle - leftCandle -
                        (candleCount[rightCandle] - candleCount[leftCandle]);
            }

            return res;
        }
    }
}
