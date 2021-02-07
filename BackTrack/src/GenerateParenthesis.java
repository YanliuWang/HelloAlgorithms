import java.util.ArrayList;
import java.util.List;

/**
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

            StringBuilder sb = new StringBuilder();

            backTrack(sb, res, 0, 0, n);

            return res;
        }

        private void backTrack(StringBuilder sb, List<String> res, int open, int close, int max) {
            if (open == max && close == max) {
                res.add(sb.toString());
                return;
            }

            if (open < max) {
                sb.append('(');
                backTrack(sb, res, open+1, close, max);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (close < open) {
                sb.append(')');
                backTrack(sb, res, open, close+1, max);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
