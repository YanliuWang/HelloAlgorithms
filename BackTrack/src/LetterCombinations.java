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
        private String[] mapping = new String[]{"0", "1",
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

            dfs(curr, 0, digits);

            return res;
        }

        private void dfs(LinkedList<Character> curr, int l, String digits) {
            // 结束条件
            if (l == digits.length()) {
                res.add(listToString(curr));
                return;
            }

            String choice = mapping[Character.getNumericValue(digits.charAt(l))];

            for (int i = 0; i < choice.length(); i++) {
                // 做选择
                curr.add(choice.charAt(i));

                // 进入下一层决策
                dfs(curr, l + 1, digits);

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
}
