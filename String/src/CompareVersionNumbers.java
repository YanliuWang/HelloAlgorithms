/**
 * LeetCode165
 * @author yanliu
 * @create 2023-01-16-11:08 PM
 */
public class CompareVersionNumbers {
    static class Solution1 {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            int i = 0, j = 0;

            while (i < v1.length || j < v2.length) {
                String r1 = i < v1.length ? v1[i++] : "0";
                String r2 = j < v2.length ? v2[j++] : "0";

                int res = compare(r1, r2);

                if (res == 1 || res == -1) {
                    return res;
                }

            }

            return 0;
        }

        private int compare(String str1, String str2) {
            int res1 = getValue(str1);
            int res2 = getValue(str2);

            if (res1 < res2) {
                return -1;
            }

            if (res1 > res2) {
                return 1;
            }

            return 0;
        }

        private int getValue(String str) {
            int res = 0;

            for (int i = 0; i < str.length(); i++) {
                int curr = str.charAt(i) - '0';
                res = res * 10 + curr;
            }

            return res;
        }
    }

    static class Solution2 {
        public int compareVersion(String version1, String version2) {
            int i = 0;
            int j = 0;

            while (i < version1.length() || j < version2.length()) {
                int first = 0;
                while (i < version1.length() && version1.charAt(i) != '.') {
                    int curr = version1.charAt(i) - '0';
                    first = curr + first * 10;
                    i++;
                }
                i++;

                int second = 0;
                while (j < version2.length() && version2.charAt(j) != '.') {
                    int curr = version2.charAt(j) - '0';
                    second = curr + second * 10;
                    j++;
                }
                j++;

                if (first > second) {
                    return 1;
                }

                if (first < second) {
                    return -1;
                }
            }

            return 0;
        }
    }
}
