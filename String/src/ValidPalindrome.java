/**
 * @author yanliu
 * @create 2021-06-30-10:29
 */
public class ValidPalindrome {
    /**
     * LC125
     */
    class Solution1 {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }

            int len = s.length();
            if (len < 2) {
                return true;
            }

            int left = 0, right = len - 1;

            while (left < right) {
                while (left < right && !isValid(s.charAt(left))) {
                    // get the left valid character
                    left++;
                }

                while (left < right && !isValid(s.charAt(right))) {
                    // get the right valid character
                    right--;
                }

                if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;

        }

        private boolean isValid(char ch) {
            return Character.isDigit(ch) || Character.isLetter(ch);
        }

        private boolean isEqual(char ch1, char ch2) {
            return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
        }
    }

    /**
     * LC680
     */
    class Solution2 {
        class Pair {
            int left, right;

            public Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        public boolean validPalindrome(String s) {
            if (s == null) {
                return false;
            }

            if (s.length() < 2) {
                return true;
            }

            // find the first difference position
            Pair pair = findDifference(s, 0, s.length() - 1);

            if (pair.left >= pair.right) {
                return true;
            }

            return isPalindrome(s, pair.left + 1, pair.right)
                    || isPalindrome(s, pair.left, pair.right - 1);
        }

        private Pair findDifference(String s, int left, int right) {
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }

            return new Pair(left, right);
        }

        private boolean isPalindrome(String s, int left, int right) {
            Pair pair = findDifference(s, left, right);

            return pair.left >= pair.right;
        }
    }

    /**
     * LeetCode680
     */
    static class Solution3 {
        public boolean validPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return isValid(s, left + 1, right) || isValid(s, left, right - 1);

                }

                left++;
                right--;
            }

            return true;

        }

        private boolean isValid(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }
    }
}
