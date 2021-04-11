import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode3
 * @author yanliu
 * @create 2021-04-11-13:02
 */
public class LengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charToIdx = new HashMap<>();

            int maxLen = 0;
            int left = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (charToIdx.containsKey(ch)) {
                    left = Math.max(left, charToIdx.get(ch) + 1);
                }

                charToIdx.put(ch, i);

                maxLen = Math.max(maxLen, i - left + 1);
            }

            return maxLen;
        }
    }
}
