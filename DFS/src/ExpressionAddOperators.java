import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 282
 * @author yanliu
 * @create 2021-11-15-8:21 PM
 */
public class ExpressionAddOperators {
    static class Solution {
        public List<String> addOperators(String num, int target) {
            // 1. we need to record the last expression that we meet before
                // 2. deal with * or / expression
            // 2. we need to deal with the invalid  number like 082

            List<String> res = new ArrayList<>();

            if (num == null || num.length() == 0) {
                return res;
            }

            dfs(num, target, 0, "", 0, 0, res);

            return res;
        }

        private void dfs(String num, int target, int start, String path, long pathValue, long last, List<String> res) {
            if (start == num.length()) {
                if (pathValue == target) {
                    res.add(path);
                }

                return;
            }

            for (int i = start; i < num.length(); i++) {
                // avoid invalid num
                if (i != start && num.charAt(start) == '0') {
                    break;
                }

                String currPath = num.substring(start, i + 1);
                long currValue = Long.valueOf(currPath);

                if (start == 0) {
                    dfs(num, target, i + 1, path + currPath, currValue, currValue, res);
                } else {
                    dfs(num, target, i + 1, path + "+" + currPath, pathValue + currValue, currValue, res);
                    dfs(num, target, i + 1, path + "-" + currPath, pathValue - currValue, -currValue, res);
                    dfs(num, target, i + 1, path + "*" + currPath, pathValue - last + last * currValue, last * currValue, res);
                }

            }
        }
    }

}
