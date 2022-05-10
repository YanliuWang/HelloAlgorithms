import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode2260
 * @author yanliu
 * @create 2022-05-08-4:20 PM
 */
public class MinimumConsecutiveCardsToPickUp {
    class Solution1 {
        public int minimumCardPickup(int[] cards) {
            if (cards == null || cards.length == 0) {
                return 0;
            }

            Map<Integer, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int res = Integer.MAX_VALUE;

            while (right < cards.length) {
                int in = cards[right];
                right++;
                window.put(in, window.getOrDefault(in, 0) + 1);

                while (right - left > 0 && window.get(in) > 1) {
                    res = Math.min(res, right - left);

                    int out = cards[left];
                    left++;

                    window.put(out, window.get(out) - 1);
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    class Solution2 {
        public int minimumCardPickup(int[] cards) {
            if (cards == null || cards.length == 0) {
                return -1;
            }

            Map<Integer, Integer> numToIdx = new HashMap<>();
            int min = cards.length + 1;

            for (int i = 0; i < cards.length; i++) {
                if (numToIdx.containsKey(cards[i])) {
                    min = Math.min(min, i - numToIdx.get(cards[i]) + 1);

                }

                numToIdx.put(cards[i], i);
            }

            return min == cards.length + 1 ? -1 : min;
        }
    }
}
