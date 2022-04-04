/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * @author yanliu
 * @create 2022-03-18-10:24 PM
 */
import java.util.*;

class LongestSubstringKDistinct {
    static class Solution1 {
        public int findLength(String str, int k) {
            if (str == null || str.length() == 0) {
                return 0;
            }

            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0;
            int max = 0;

            while (right < str.length()) {
                char in = str.charAt(right);
                window.put(in, window.getOrDefault(in, 0) + 1);
                right++;

                while (window.size() > k) {
                    char out = str.charAt(left);
                    window.put(out, window.get(out) - 1);

                    if (window.get(out) == 0) {
                        window.remove(out);
                    }

                    left++;

                }

                max = Math.max(max, right - left);

            }

            return max;
        }
    }
}
