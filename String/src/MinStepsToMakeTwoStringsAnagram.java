/**
 * LeetCode 1347
 * @author yanliu
 * @create 2021-11-21-10:36 AM
 */
public class MinStepsToMakeTwoStringsAnagram {
    static class Solution {
        public int minSteps(String s, String t) {
            int[] chars = new int[26];

            // map the character to integer
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }

            int ans = 0;

            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i) - 'a';
                chars[index]--;

                if (chars[index] < 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
}
