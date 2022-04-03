/**
 * @author yanliu
 * @create 2022-03-27-4:37 PM
 */
public class LongestCommonPrefix {
    // horizontal comparison
    static class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);

                    if (prefix.isEmpty()) {
                        return "";

                    }
                }
            }

            return prefix;
        }
    }

    // vertical comparison
    static class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            for (int i = 0; i < strs[0].length(); i++) {
                char curr = strs[0].charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != curr) {
                        return strs[0].substring(0, i);

                    }
                }
            }

            return strs[0];

        }
    }

    // divide and conquer strategy
    static class Solution3 {
        public String longestCommonPrefix(String[] strs) {
            return getLCP(strs, 0, strs.length - 1);
        }

        private String getLCP(String[] strs, int left, int right) {
            if (strs[left] == strs[right]) {
                return strs[left];

            }

            int mid = left + (right - left) / 2;

            String leftLCP = getLCP(strs, left, mid);
            String rightLCP = getLCP(strs, mid + 1, right);

            return common(leftLCP, rightLCP);

        }

        private String common(String str1, String str2) {
            int minLen = Math.min(str1.length(), str2.length());

            for (int i = 0; i < minLen; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return str1.substring(0, i);

                }
            }

            return str1.substring(0, minLen);
        }
    }

    // binary search solution
    static class Solution4 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int minLen = Integer.MAX_VALUE;

            for (int i = 0; i < strs.length; i++) {
                minLen = Math.min(minLen, strs[i].length());
            }

            int low = 1, high = minLen;

            while (low + 1 < high) {
                int mid = low + (high - low) / 2;

                if (isCommonPrefix(strs, mid)) {
                    low = mid;

                } else {
                    high = mid - 1;

                }
            }

            if (isCommonPrefix(strs, high)) {
                return strs[0].substring(0, high);
            }

            if (isCommonPrefix(strs, low)) {
                return strs[0].substring(0, low);
            }

            return "";
        }

        private boolean isCommonPrefix(String[] strs, int len) {
            String prefix = strs[0].substring(0, len);

            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    return false;
                }
            }

            return true;
        }
    }
}
