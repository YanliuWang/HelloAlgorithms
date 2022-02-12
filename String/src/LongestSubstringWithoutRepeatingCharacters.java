import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3
 * @author yanliu
 * @create 2021-11-14-11:36 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int res = 0;
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                window.put(in, window.getOrDefault(in, 0) + 1);

                while (window.get(in) > 1) {
                    char out = s.charAt(left);
                    left++;

                    window.put(out, window.get(out) - 1);
                }

                if (right - left > res) {
                    res = right - left;
                }
            }

            return res;

        }
    }

    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0;
            int[] window = new int[128];
            int res = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                window[in]++;
                right++;

                while (window[in] > 1) {
                    char out = s.charAt(left);
                    window[out]--;
                    left++;
                }

                res = Math.max(res, right - left);
            }

            return res;
        }
    }

    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[128];
            int maxLen = 0;

            int left = 0, right = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                count[in]++;

                // since left will not exceed right
                while (left < right && count[in] > 1) {
                    char out = s.charAt(left);
                    left++;

                    count[out]--;
                }

                if (right - left > maxLen) {
                    maxLen = right - left;
                }
            }

            return maxLen;

        }
    }
}
