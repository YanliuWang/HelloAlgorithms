/**
 * LeetCode696
 * @author yanliu
 * @create 2022-01-03-7:15 PM
 */
public class CountBinarySubstrings {
    static class Solution1 {
        public int countBinarySubstrings(String s) {
            int count = 0;
            int n = s.length();
            int m = 0;

            int[] group = new int[n];
            group[0] = 1;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    group[m]++;

                } else {
                    group[++m] = 1;
                }
            }

            for (int i = 1; i <= m; i++) {
                count += Math.min(group[i], group[i - 1]);
            }

            return count;
        }
    }

    static class Solution2 {
        public int countBinarySubstrings(String s) {
            int res = 0, prev = 0, curr = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    res += Math.min(prev, curr);
                    prev = curr;
                    curr = 1;

                } else {
                    curr++;
                }
            }

            return res + Math.min(prev, curr);
        }
    }
}
