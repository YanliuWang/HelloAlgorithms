import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode76
 * @author yanliu
 * @create 2022-01-15-3:28 PM
 */
public class MinimumWindowSubstring {
    static class Solution1 {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }

            Map<Character, Integer> needed = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                needed.put(ch, needed.getOrDefault(ch, 0) + 1);
            }

            int required = needed.size();
            int formed = 0;

            int left = 0, right = 0;
            int min = Integer.MAX_VALUE;
            int start = 0, end = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                window.put(in, window.getOrDefault(in, 0) + 1);

                if (needed.containsKey(in)
                        && window.get(in).equals(needed.get(in))) {
                    formed++;
                }

                while (left < right && formed == required) {

                    if (right - left < min) {
                        min = right - left;
                        start = left;
                        end = right;
                    }

                    char out = s.charAt(left);
                    left++;

                    if (needed.containsKey(out)
                            && window.get(out).equals(needed.get(out))) {
                        formed--;
                    }

                    window.put(out, window.get(out) - 1);

                }

            }

            return s.substring(start, end);

        }
    }

    static class Solution2 {
        public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();

            int[] window = new int[128];
            int[] need = new int[128];

            int required = 0;

            for (int i = 0; i < n; i++) {
                char ch = t.charAt(i);
                need[ch - '0']++;
            }

            for (int i = 0; i < need.length; i++) {
                if (need[i] != 0) {
                    required++;
                }
            }


            int left = 0, right = 0;
            int matched = 0;
            int min = m + 1;
            int start = 0, end = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                window[in - '0']++;

                if (window[in - '0'] == need[in - '0']) {
                    matched++;
                }

                // if t is all matched in s
                while (left < right && matched == required) {
                    if (right - left < min) {
                        min = right - left;
                        start = left;
                        end = right;
                    }

                    char out = s.charAt(left);
                    left++;

                    if (window[out - '0'] == need[out - '0']) {
                        matched--;
                    }

                    window[out - '0']--;
                }

            }

            return s.substring(start, end);
        }
    }
}
