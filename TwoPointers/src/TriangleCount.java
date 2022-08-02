import java.util.Arrays;

/**
 * LintCode382
 * @author yanliu
 * @create 2022-08-01-5:09 PM
 */
public class TriangleCount {
    static class Solution1 {
        /**
         * 确定最小的边，使用同向双指针，枚举剩下两条边
         * @param s: A list of integers
         * @return: An integer
         */
        public int triangleCount(int[] s) {
            // write your code here
            if (s == null || s.length == 0) {
                return 0;
            }

            Arrays.sort(s);

            int res = 0;

            for (int i = 0; i < s.length - 2; i++) {
                int left = i + 1;
                int right = i + 2;

                while (right < s.length) {
                    int diff = s[right] - s[left];

                    if (diff < s[i]) {
                        res += right - left;
                        right++;

                    } else {
                        left++;

                    }

                    if (left == right) {
                        right++;
                    }
                }
            }

            return res;
        }
    }

    public class Solution {
        /**
         * 枚举最大的边，枚举剩下两条最小的边
         * @param s: A list of integers
         * @return: An integer
         */
        public int triangleCount(int[] s) {
            // write your code here
            if (s == null || s.length == 0) {
                return 0;
            }

            Arrays.sort(s);

            int res = 0;

            for (int i = s.length - 1; i >= 2; i--) {
                int left = 0, right = i - 1;

                while (left < right) {
                    int sum = s[left] + s[right];

                    if (sum > s[i]) {
                        res += right - left;
                        right--;

                    } else {
                        left++;

                    }
                }
            }

            return res;
        }
    }
}
