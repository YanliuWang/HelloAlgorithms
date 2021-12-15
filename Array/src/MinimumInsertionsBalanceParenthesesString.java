/**
 * LeetCode1541
 * @author yanliu
 * @create 2021-12-14-6:03 PM
 */
public class MinimumInsertionsBalanceParenthesesString {
    static class Solution {
        public int minInsertions(String s) {
            int insert = 0, right = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    right += 2;

                    if (right % 2 == 1) {
                        // insert one left
                        insert++;
                        // right need --
                        right--;
                    }
                }

                if (ch == ')') {
                    right--;

                    if (right == -1) {
                        right = 1;
                        insert++;
                    }

                }
            }

            return insert + right;
        }
    }
}
