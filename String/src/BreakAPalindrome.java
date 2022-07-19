/**
 * LeetCode1328
 * @author yanliu
 * @create 2022-07-12-3:39 PM
 */
public class BreakAPalindrome {
    class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome == null || palindrome.length() == 0) {
                return "";
            }

            char[] arr = palindrome.toCharArray();

            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != 'a') {
                    arr[i] = 'a';
                    return new String(arr);
                }
            }

            arr[arr.length - 1] = 'b';

            return arr.length < 2 ? "" : new String(arr);
        }
    }
}
