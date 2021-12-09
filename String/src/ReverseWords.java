/**
 * LeetCode 151
 * @author yanliu
 * @create 2021-11-15-10:19 PM
 */
public class ReverseWords {
    static class Solution {
        public String reverseWords(String s) {
            // 1. reverse the string s
            int len = s.length();
            char[] charArray = s.toCharArray();

            reverse(charArray, 0, len -1);

            // 2. reverse the words in the string s
            reverseWords(charArray, len);

            // 3. delete extra space
            return deleteExtraSpace(charArray, len);

        }

        private void reverse(char[] charArray, int left, int right) {
            while (left <= right) {
                swap(charArray, left, right);
                left++;
                right--;
            }
        }

        private void reverseWords(char[] charArray, int len) {
            // i points to the start of a word
            // j points to the end of a word
            int start = 0, end = 0;

            while (start < len) {
                // make start == end
                while (start < end) {
                    start++;
                }

                // go to the start of a word
                while (start < len && charArray[start] == ' ') {
                    start++;
                }

                // make end == start
                while (end < start) {
                    end++;
                }

                // go the end of a word + 1
                while (end < len && charArray[end] != ' ') {
                    end++;
                }

                reverse(charArray, start, end - 1);
            }
        }

        private String deleteExtraSpace(char[] charArray, int len) {
            int i = 0;
            int j = 0;

            while (j < len) {
                // go to the first non-space
                while (j < len && charArray[j] == ' ') {
                    j++;
                }

                // copy non-space
                while (j < len && charArray[j] != ' ') {
                    charArray[i++] = charArray[j++];
                }

                // go the next non-space
                while (j < len && charArray[j] == ' ') {
                    j++;
                }

                // still have non-space
                // use ' ' to split
                if (j < len) {
                    charArray[i++] = ' ';
                }
            }

            // remove the last ' '
            return new String(charArray).substring(0, i);

        }



        private void swap(char[] charArray, int i, int j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
        }
    }
}
