/** LC5
 * @author yanliu
 * @create 2020-12-08-22:51
 */
public class LongestPalindrome {
    /**
     * brute force method
     */
    static class Solution1 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            // n start point and n end point
            for (int length = s.length(); length >= 1; length--) {
                for (int start = 0; start + length <= s.length(); start++) {
                    if (isPalindrome(s, start, start + length - 1)) {
                        return s.substring(start, start + length);
                    }
                }
            }

            return "";
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }

            return left >= right;
        }
    }


    /**
     * enumeration method
     */
    static class Solution2 {
        /**
         * get the longest palindrome
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            String longest = "";

            for (int i = 0; i < s.length(); i++) {
                // the length of s could be odd or even

                // get odd palindrome whose center is at each char position
                String oddPalindrome = getLongestPalindrome(s, i, i);

                // get even palindrome whose center is between two chars
                String evenPalindrome = getLongestPalindrome(s, i, i + 1);

                longest = longest.length() > oddPalindrome.length() ? longest : oddPalindrome;
                longest = longest.length() > evenPalindrome.length() ? longest : evenPalindrome;
            }

            return longest;
        }

        /**
         * return the palindrome whose centers are s[l] and s[r]
         * @param s
         * @param l
         * @param r
         * @return
         */
        private String getLongestPalindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }

                l--; r++;
            }

            return s.substring(l + 1, r);
        }
    }

    /**
     * dp method
     */
    static class Solution3 {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];

            int longest = 1;
            int start = 0;

            // length is 1
            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
            }

            // length is 2
            for (int i = 0; i < n -1; i++) {
                isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);

                if (isPalindrome[i][i + 1]) {
                    longest = 2;
                    start = i;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

                    if (isPalindrome[i][j] && j - i + 1 > longest) {
                        longest = j - i + 1;
                        start = i;
                    }
                }
            }

            return s.substring(start, start + longest);
        }
    }
}
