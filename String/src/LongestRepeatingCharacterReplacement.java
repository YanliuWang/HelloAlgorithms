/**
 * LeetCode424
 * @author yanliu
 * @create 2022-02-21-4:26 PM
 */
public class LongestRepeatingCharacterReplacement {
    static class Solution {
        public int characterReplacement(String s, int k) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int left = 0, right = 0;
            int[] count = new int[26];
            // max count of single unique character in each window
            int maxCount = 0;

            int maxLen = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                count[in - 'A']++;
                maxCount = Math.max(maxCount, count[in - 'A']);

                while (right - left - maxCount > k) {
                    char out = s.charAt(left);
                    left++;

                    count[out - 'A']--;
                }

                maxLen = Math.max(maxLen, right - left);
            }

            return maxLen;
        }
    }
}
