/**
 * Leetcode880
 * @author yanliu
 * @create 2022-02-21-10:58 AM
 */
public class DecodedStringAtIndex {
    class Solution {
        public String decodeAtIndex(String s, int k) {
            long size = 0;
            int index = 0;

            // calculate the length after decoding
            while (size < k) {
                char ch = s.charAt(index);

                if (Character.isDigit(ch)) {
                    size *= (ch - '0');

                } else {
                    size++;

                }

                index++;
            }


            // remove to the previous index -> size >= k
            index--;

            while (index > 0) {
                char ch = s.charAt(index);

                if (Character.isDigit(ch)) {
                    size /= (ch - '0');
                    // k == k % size after decoding
                    k %= size;

                } else {
                    if (k % size == 0) {
                        break;

                    }

                    size--;
                }

                index--;
            }

            return Character.toString(s.charAt(index));

        }

    }
}
