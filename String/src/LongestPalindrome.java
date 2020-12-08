/**
 * @author yanliu
 * @create 2020-12-08-22:51
 */
public class LongestPalindrome {
    static class Solution {
        /**
         * get the longest palindrome
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            String res = new String();

            for (int i = 0; i < s.length(); i++) {
                // the length of s could be odd or even
                // we look for the palindrome whose center are i and i + 1
                String s1 = longestPalindrome(s, i, i);
                String s2 = longestPalindrome(s, i, i + 1);

                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }

            return res;
        }

        /**
         * return the palindrome whose centers are s[l] and s[r]
         * @param s
         * @param l
         * @param r
         * @return
         */
        private String longestPalindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }

            return s.substring(l + 1, r);
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
