/**
 * LeetCode1614
 * @author yanliu
 * @create 2022-09-25-12:22 PM
 */
public class MaximumNestingDepthOfTheParentheses {
    class Solution {
        public int maxDepth(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int res = 0;
            int curr = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    curr++;
                    res = Math.max(res, curr);

                } else if (ch == ')'){
                    curr--;

                }
            }

            return res;
        }
    }
}
