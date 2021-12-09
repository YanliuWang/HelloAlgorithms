/**
 * LeetCode557
 * @author yanliu
 * @create 2021-12-06-9:54 AM
 */
public class ReverseWordsInAString {
    static class Solution {
        public String reverseWords(String s) {
            char[] arr = s.toCharArray();

            int left = 0, right = 0;

            while (right < arr.length) {
                while (right < arr.length && arr[right] != ' ') {
                    right++;
                }

                reverse(arr, left, right - 1);

                if (right + 1 == arr.length) {
                    reverse(arr, left, right);
                    break;
                }

                left = right + 1;

                while (right < arr.length && arr[right] == ' ') {
                    right++;
                }

            }

            return new String(arr);
        }

        private void reverse(char[] s, int left, int right) {
            while (left < right) {
                swap(s, left, right);
                left++;
                right--;
            }
        }

        private void swap(char[] s, int index1, int index2) {
            char tmp = s[index1];
            s[index1] = s[index2];
            s[index2] = tmp;
        }


    }
}
