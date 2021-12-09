import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3
 * @author yanliu
 * @create 2021-11-14-11:36 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
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
}
