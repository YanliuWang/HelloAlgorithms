/**
 * LeetCode383
 * @author yanliu
 * @create 2021-12-15-11:24 PM
 */
public class RansomNote {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] freq = new int[26];
            for (int i = 0; i < magazine.length(); i++) {
                freq[magazine.charAt(i) - 'a']++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                int ch = ransomNote.charAt(i) - 'a';
                freq[ch]--;

                if (freq[ch] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
