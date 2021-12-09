import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6
 * @author yanliu
 * @create 2021-11-24-12:16 AM
 */
public class ZigzagConversion {
    static class Solution {
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
}
