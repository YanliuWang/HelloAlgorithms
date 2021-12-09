import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode22
 * @author yanliu
 * @create 2021-02-07-15:06
 */
public class GenerateParenthesis {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();

            if (n <= 0) {
                return res;
            }

            dfs(n, n, new StringBuilder(), res);

            return res;
        }

        private void dfs(int left, int right, StringBuilder path, List<String> res) {
            if (left > right) {
                return;
            }

            if (left < 0 || right < 0) {
                return;
            }

            if (left == 0 && right == 0) {
                res.add(path.toString());
                return;
            }

            // append open bracket firstly
            path.append("(");
            dfs(left - 1, right, path, res);
            path.deleteCharAt(path.length() - 1);

            // append closed bracket secondly
            path.append(")");
            dfs(left, right - 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
