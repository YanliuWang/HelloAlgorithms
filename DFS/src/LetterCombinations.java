import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LC17
 * @author yanliu
 * @create 2021-01-26-17:37
 */
public class LetterCombinations {
    /**
     * DFS/backTrack
     */
    static class Solution1 {
        private final String[] mapping = new String[]{"0", "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};

        private List<String> res = new LinkedList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return res;
            }

            LinkedList<Character> curr = new LinkedList<>();

            dfs(curr, digits, 0);

            return res;
        }

        private void dfs(LinkedList<Character> curr, String digits, int start) {
            // 结束条件
            if (start == digits.length()) {
                res.add(listToString(curr));
                return;
            }

            String choice = mapping[Character.getNumericValue(digits.charAt(start))];

            for (int i = 0; i < choice.length(); i++) {
                // 做选择
                curr.add(choice.charAt(i));

                // 进入下一层决策
                dfs(curr, digits, start + 1);

                curr.removeLast();

            }


        }

        private String listToString(LinkedList<Character> digits) {
            StringBuilder sb = new StringBuilder();

            for (Character ch : digits) {
                sb.append(ch);
            }

            return sb.toString();
        }
    }

    /**
     * BFS
     */
    static class Solution2 {
        private String[] mapping = new String[]{"0", "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return res;
            }

            res.add("");

            for (char digit : digits.toCharArray()) {
                List<String> tmp = new ArrayList<>();

                for (String prev : res) {
                    String choice = mapping[Character.getNumericValue(digit)];

                    for (int i = 0; i < choice.length(); i++) {
                        tmp.add(prev + choice.charAt(i));
                    }

                    res = tmp;
                }
            }

            return res;
        }
    }

    static class Solution3 {
        private final String[] numToLetters = new String[]{"0", "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return res;
            }

            backtrack(digits, new StringBuilder(), res, 0);

            return res;
        }

        private void backtrack(String digits, StringBuilder path, List<String> res, int start) {
            // end condition
            if (start == digits.length()) {
                res.add(new String(path));
                return;
            }

            // get the choice
            char digit = digits.charAt(start);
            int index = digit - '0';
            String choice = numToLetters[index];

            for (int i = 0; i < choice.length(); i++) {
                // process
                path.append(choice.charAt(i));

                // recursive rule
                backtrack(digits, path, res, start + 1);

                // backtrack
                path.deleteCharAt(path.length() - 1);
            }

        }
    }
}
