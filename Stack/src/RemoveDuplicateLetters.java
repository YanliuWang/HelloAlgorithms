import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode316
 * @author yanliu
 * @create 2021-12-22-12:17 PM
 */
public class RemoveDuplicateLetters {
    static class Solution {
        public String removeDuplicateLetters(String s) {
            int len = s.length();
            // remaining string frequency
            int[] freq = new int[26];
            // whether stack contains
            boolean[] isVisited = new boolean[26];
            // answer stack
            Deque<Character> stack = new ArrayDeque<>();

            // frequency array
            for (int i = 0; i < len; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']--;

                if (isVisited[ch - 'a']) {
                    continue;
                }

                while (!stack.isEmpty() && stack.peek() > ch
                        && freq[stack.peek() - 'a'] > 0) {
                    isVisited[stack.pop() - 'a'] = false;
                }

                stack.push(ch);
                isVisited[ch - 'a'] = true;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }

            return sb.toString();
        }
    }
}
