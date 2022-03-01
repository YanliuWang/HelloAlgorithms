import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yanliu
 * @create 2022-02-21-5:45 PM
 */
public class BraceExpansion {
    static class Solution {
        public String[] expand(String s) {
            if (s == null || s.length() == 0) {
                return new String[0];
            }

            List<String> res = new ArrayList<>();

            dfs(s, 0, new StringBuilder(), res);

            String[] arr = new String[res.size()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }

        private void dfs(String s, int index, StringBuilder curr, List<String> res) {
            if (index == s.length()) {
                res.add(curr.toString());
                return;
            }

            if (s.charAt(index) == '{') {
                // skip '{'
                index++;

                List<Character> options = new ArrayList<>();

                while (s.charAt(index) != '}') {
                    char ch = s.charAt(index++);

                    if (ch == ',') {
                        continue;
                    }

                    options.add(ch);

                }

                Collections.sort(options);

                for (Character option : options) {
                    curr.append(option);

                    dfs(s, index + 1, curr, res);

                    curr.deleteCharAt(curr.length() - 1);
                }

            } else {
                curr.append(s.charAt(index));

                dfs(s, index + 1, curr, res);

                curr.deleteCharAt(curr.length() - 1);

            }
        }
    }
}
