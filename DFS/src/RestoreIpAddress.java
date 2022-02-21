import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode93
 * @author yanliu
 * @create 2021-12-30-9:08 PM
 */
public class RestoreIpAddress {
    static class Solution1 {
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
                // remove the first '.'
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

    static class Solution2 {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();

            if (s == null || s.length() < 4) {
                return res;
            }

            dfs(s, 0, new StringBuilder(), 0, res);

            return res;
        }

        // start: starting index, field: numbers added into StringBuilder
        private void dfs(String s, int start, StringBuilder path, int field, List<String> res) {
            // if we are at the end and added 4 elements, add to result
            if (start == s.length() && field == 4) {
                res.add(path.toString());
                return;
            }

            // if we are not at the end and already has 4 elements-> invalid
            if (start == s.length() || field == 4) {
                return;
            }

            for (int end = start; end < s.length(); end++) {
                String curr = s.substring(start, end + 1);
                int val = Integer.parseInt(curr);

                // check whether the number is like "0010" or "00";
                if (curr.length() > 1 && curr.charAt(0) == '0') {
                    return;
                }

                // out of range
                if (val > 255) {
                    return;
                }

                // less or equal to 255
                if (val >= 0 && val <= 255) {
                    // record previous state
                    StringBuilder rollback = new StringBuilder(path);

                    path.append(val);

                    if (field < 3) {
                        path.append(".");
                    }

                    // Backtracking
                    dfs(s, end + 1, path, field + 1, res);

                    // Rollback to previous state
                    path = rollback;
                }

            }
        }
    }
}
