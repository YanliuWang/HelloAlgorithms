/**
 * LeetCode1963
 * @author yanliu
 * @create 2022-03-14-6:15 PM
 */
public class MinimumNumberOfSwapsMakeStringBalanced {
    static class Solution {
        public int minSwaps(String s) {
            int stackSize = 0;
            int misMatches = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    stackSize++;

                } else {
                    if (stackSize > 0) {
                        stackSize--;

                    } else {
                        misMatches++;

                    }
                }
            }

            return (misMatches + 1) / 2;
        }
    }
}
