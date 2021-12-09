/**
 * LeetCode 696
 * @author yanliu
 * @create 2021-11-20-10:44 PM
 */
public class CountBinarySubstrings {
    static class Solution {
        public int countBinarySubstrings(String s) {
            int preGroup = 0, currGroup = 1, res = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currGroup++;

                } else {
                    preGroup = currGroup;
                    currGroup = 1;

                }

                if (preGroup >= currGroup) {
                    res++;
                }
            }

            return res;

        }
    }
}
