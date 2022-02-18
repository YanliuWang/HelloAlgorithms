/**
 * LeetCode443
 * @author yanliu
 * @create 2022-02-16-6:42 PM
 */
public class StringCompression {
    static class Solution {
        public int compress(char[] chars) {
            int slow = 0, fast = 0;

            while (fast < chars.length) {
                char curr = chars[fast];
                int count = 0;

                while (fast < chars.length && chars[fast] == curr) {
                    fast++;
                    count++;
                }

                chars[slow++] = curr;

                if (count == 1) {
                    continue;
                }

                for (char ch : Integer.toString(count).toCharArray()) {
                    chars[slow++] = ch;
                }

            }

            return slow;

        }
    }
}
