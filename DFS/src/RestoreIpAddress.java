import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode93
 * @author yanliu
 * @create 2021-12-30-9:08 PM
 */
public class RestoreIpAddress {
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();

            if (s == null || s.length() == 0 || s.length() > 12) {
                return res;
            }

            backtrack(s, "", 0, res);

            return res;
        }

        private void backtrack(String s, String curr, int field, List<String> res) {
            if (field == 4 && s.length() == 0) {
                res.add(curr.substring(1));
                return;
            }

            if (field == 4 || s.length() == 0) {
                return;
            }

            // ip field length is 1
            backtrack(s.substring(1), curr + "." + s.substring(0, 1), field + 1, res);

            // ip field length is 2
            if (s.charAt(0) != '0' && s.length() > 1) {
                backtrack(s.substring(2), curr + "." + s.substring(0, 2), field + 1, res);
            }

            // ip field length is 3
            if (s.charAt(0) != '0' && s.length() > 2
                    && Integer.valueOf(s.substring(0, 3)) <= 255) {
                backtrack(s.substring(3), curr + "." + s.substring(0, 3), field + 1, res);
            }
        }
    }
}
