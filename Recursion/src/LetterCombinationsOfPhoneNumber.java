import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode17
 * @author yanliu
 * @create 2022-07-07-7:40 PM
 */
public interface LetterCombinationsOfPhoneNumber {
    class Solution {
        private String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return res;
            }

            dfs(digits, 0, new StringBuilder(), res);

            return res;
        }

        private void dfs(String digits, int start, StringBuilder sb, List<String> res) {
            if (start == digits.length()) {
                res.add(sb.toString());
                return;
            }

            String letters = map[digits.charAt(start) - '0'];

            for (char letter : letters.toCharArray()) {
                sb.append(letter);

                dfs(digits, start + 1, sb, res);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
