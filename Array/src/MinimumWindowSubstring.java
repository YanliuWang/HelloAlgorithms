import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76
 * @author yanliu
 * @create 2021-10-16-3:48 PM
 */
public class MinimumWindowSubstring {
    static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            // construct need map
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

            // the number of satisfied matches
            int valid = 0;
            int left = 0, right = 0;
            int len = s.length() + 1;
            int start = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                // update when window extends to right
                if (need.containsKey(in)) {
                    window.put(in, window.getOrDefault(in, 0) + 1);

                    if ((window.get(in)).equals(need.get(in))) {
                        valid++;
                    }
                }

                // shrink the window left
                while (valid == need.size()) {
                    char out = s.charAt(left);

                    // get the len of substring
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    left++;

                    if (need.containsKey(out)) {
                        if ((need.get(out)).equals(window.get(out))) {
                            valid--;
                        }

                        window.put(out, window.get(out) - 1);
                    }
                }

            }
            // System.out.println(len);

            return len == s.length() + 1 ? "" : s.substring(start, start + len);
        }
    }
}
