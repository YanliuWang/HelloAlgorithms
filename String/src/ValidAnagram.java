/**
 * LeetCode242
 * @author yanliu
 * @create 2021-12-15-11:33 PM
 */
public class ValidAnagram {
    static class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int n = s.length();
            int[] freq = new int[26];

            for (int i = 0; i < n; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                int index = t.charAt(i) - 'a';

                freq[index]--;

                if (freq[index] < 0) {
                    return false;
                }
            }

            return true;

        }
    }

    /**
     * follow up: what is Unicode?
     */
    static class Solution2 {

    }


}
