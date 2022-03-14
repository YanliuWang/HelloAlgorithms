import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6
 * @author yanliu
 * @create 2021-11-24-12:16 AM
 */
public class ZigzagConversion {
    static class Solution1 {
        public String convert(String s, int numRows) {
            if (numRows < 2) {
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                rows.add(new StringBuilder());
            }

            int flag = -1, currRow = 0;
            for (char c : s.toCharArray()) {
                rows.get(currRow).append(c);

                if (currRow == 0 || currRow == numRows - 1) {
                    flag = -flag;
                }

                currRow += flag;
            }

            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) {
                res.append(row);
            }

            return res.toString();
        }
    }

    static class Solution2 {
        public String convert(String s, int numRows) {
            if (s == null || s.length() == 0) {
                return "";
            }

            StringBuilder[] rows = new StringBuilder[numRows];

            int n = s.length();

            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int i = 0;
            while (i < n) {
                for (int idx = 0; idx < numRows && i < n; idx++) {
                    rows[idx].append(s.charAt(i++));
                }

                for (int idx = numRows - 2; idx > 0 && i < n; idx--) {
                    rows[idx].append(s.charAt(i++));
                }
            }

            for (i = 1; i < numRows; i++) {
                rows[0].append(rows[i]);
            }

            return rows[0].toString();
        }
    }
}
