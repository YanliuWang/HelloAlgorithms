import java.util.LinkedList;
import java.util.List;

/**
 * LC301
 * @author yanliu
 * @create 2021-02-07-13:06
 */
public class RemoveInvalidParentheses {
    static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new LinkedList<>();

            dfs(s, res, 0, 0, '(', ')');

            return res;
        }

        private void dfs(String s, List<String> res, int start, int lastRemove, char openParen, char closedParen) {
            int numOpenParen = 0;
            int numClosedParen = 0;

            for (int i = start; i < s.length(); i++) {
                if (s.charAt(i) == openParen) {
                    numOpenParen++;
                }

                if (s.charAt(i) == closedParen) {
                    numClosedParen++;
                }

                // we have extra closed parentheses
                if (numClosedParen > numOpenParen) {
                    for (int j = lastRemove; j <= i; j++) {
                        if (s.charAt(j) == closedParen && (j == lastRemove || s.charAt(j - 1) != closedParen)) {
                            dfs(s.substring(0, j) + s.substring(j+1, s.length()), res, i, j, openParen, closedParen);
                        }
                    }

                    return;
                }
            }

            String reversed = new StringBuilder(s).reverse().toString();

            if (openParen == '(') {
                dfs(reversed, res, 0, 0, ')', '(');
            } else {
                res.add(reversed);
            }
        }
    }


}
