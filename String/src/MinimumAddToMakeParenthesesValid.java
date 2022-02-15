/**
 * LeetCode921
 * @author yanliu
 * @create 2021-12-06-11:24 PM
 */
public class MinimumAddToMakeParenthesesValid {
    static class Solution {
        public int minAddToMakeValid(String s) {
            int insert = 0, rightNeed = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    rightNeed++;

                } else {
                    rightNeed--;

                    if (rightNeed == -1) {
                        insert++;
                        rightNeed = 0;
                    }
                }
            }

            return insert + rightNeed;
        }
    }
}
