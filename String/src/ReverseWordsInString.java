/**
 * LeetCode151
 * @author yanliu
 * @create 2022-05-13-10:39 PM
 */
public class ReverseWordsInString {
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            StringBuilder sb = trimSpace(s);

            reverse(sb, 0, sb.length() - 1);

            reverseEachWord(sb);

            return sb.toString();
        }

        private StringBuilder trimSpace(String s) {
            int left = 0, right = s.length() - 1;

            while (left <= right && s.charAt(left) == ' ') {
                left++;
            }

            while (left <= right && s.charAt(right) == ' ') {
                right--;
            }

            StringBuilder res = new StringBuilder();

            while (left <= right) {
                char curr = s.charAt(left);

                if (curr != ' ') {
                    res.append(curr);

                } else {
                    // make sure one space between words
                    if (res.charAt(res.length() - 1) != ' ') {
                        res.append(curr);

                    }
                }

                left++;
            }

            return res;
        }

        private void reverse(StringBuilder s, int left, int right) {
            while (left <= right) {
                char tmp = s.charAt(left);
                s.setCharAt(left, s.charAt(right));
                s.setCharAt(right, tmp);

                left++;
                right--;
            }
        }

        private void reverseEachWord(StringBuilder s) {
            int start = 0, end = 0;
            int n = s.length();

            while (start < n) {
                while (end < n && s.charAt(end) != ' ') {
                    end++;
                }

                reverse(s, start, end - 1);

                start = end + 1;
                end++;
            }
        }

    }
}
