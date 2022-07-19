import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode1209
 * @author yanliu
 * @create 2022-07-11-11:54 AM
 */
public class RemoveAllAdjacentDuplicatesInString {
    class Solution1 {
        public String removeDuplicates(String s, int k) {
            if (s == null || s.length() == 0) {
                return s;
            }

            int length = -1;
            StringBuilder sb = new StringBuilder(s);

            while (length != sb.length()) {
                length = sb.length();

                for (int i = 0, count = 1; i < sb.length(); i++) {
                    if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                        count = 1;

                    } else if (++count == k) {
                        sb.delete(i - k + 1, i + 1);
                        break;
                    }
                }
            }

            return sb.toString();
        }
    }

    class Solution2 {
        public String removeDuplicates(String s, int k) {
            if (s == null || s.length() == 0) {
                return s;
            }

            StringBuilder sb = new StringBuilder(s);
            int[] count = new int[sb.length()];

            for (int i = 0; i < sb.length(); i++) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count[i] = 1;

                } else {
                    count[i] = count[i - 1] + 1;

                    if (count[i] == k) {
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    }
                }
            }

            return sb.toString();
        }
    }

    class Solution3 {
        class Pair {
            char ch;
            int count;

            public Pair(char ch, int count) {
                this.ch = ch;
                this.count = count;
            }
        }

        public String removeDuplicates(String s, int k) {
            if (s == null || s.length() == 0) {
                return "";
            }

            Deque<Pair> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                if (stack.isEmpty() || curr != stack.peek().ch) {
                    stack.push(new Pair(curr, 1));

                } else {
                    int count = stack.pop().count + 1;

                    if (count != k) {
                        stack.push(new Pair(curr, count));

                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!stack.isEmpty()) {
                Pair p = stack.pop();

                for (int i = 0; i < p.count; i++) {
                    sb.append(p.ch);
                }
            }

            return sb.reverse().toString();

        }
    }


}
