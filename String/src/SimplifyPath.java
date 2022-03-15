import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode71
 * @author yanliu
 * @create 2022-03-14-5:24 PM
 */
public class SimplifyPath {
    static class Solution {
        public String simplifyPath(String path) {
            String[] paths = split(path, '/');
            Deque<String> deque = new ArrayDeque<>();

            for (String s : paths) {
                if (s.equals("") || s.equals(".")) {
                    continue;
                }

                if (s.equals("..")) {
                    if (deque.isEmpty()) {
                        continue;
                    }

                    deque.pop();

                } else {
                    deque.push(s);

                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("/");

            while (deque.size() > 1) {
                sb.append(deque.pollLast()).append("/");
            }

            if (deque.size() == 1) {
                sb.append(deque.pollLast());
            }


            return sb.toString();
        }

        private String[] split(String s, char symbol) {
            List<String> res = new ArrayList<>();

            int start = 0;
            int n = s.length();

            while (start < n) {
                StringBuilder sb = new StringBuilder();

                while (start < n && s.charAt(start) != symbol) {
                    sb.append(s.charAt(start));
                    start++;
                }

                res.add(sb.toString());

                if (start < n) {
                    start++;
                }

            }

            String[] arr = new String[res.size()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }
    }
}
