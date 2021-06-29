/**
 * @author yanliu
 * @create 2021-06-29-11:02
 */
public class StrStr {
    /**
     * O(n^2) solution
     */
    class Solution1 {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) {
                return -1;
            }

            if (needle.length() == 0) {
                return 0;
            }

            if (haystack.length() < needle.length()) {
                return -1;
            }

            for (int sourceStart = 0; sourceStart < haystack.length() - needle.length() + 1; sourceStart++) {
                boolean isEqual = true;

                for (int targetLength = 0; targetLength < needle.length(); targetLength++) {
                    if (haystack.charAt(sourceStart + targetLength) != needle.charAt(targetLength)) {
                        isEqual = false;
                        break;
                    }

                }

                if (isEqual) {
                    return sourceStart;
                }
            }

            return -1;
        }
    }

    /**
     * O(n+m) solution
     * n is the length of source.
     * m is the length of target.
     *
     *
     */
     class Solution2 {
        private final int BASE = 1000000;

        /*
         * @param source: A source string
         * @param target: A target string
         * @return: An integer as index
         */
        public int strStr2(String source, String target) {
            // write your code here
            if (source == null || target == null) {
                return -1;
            }

            // record target length
            int m = target.length();
            if (m == 0) {
                return 0;
            }

            // get 31 ^ m
            int power = 1;
            for (int i = 0; i < m; i++) {
                power = (power * 31) % BASE;
            }

            // get target string hashcode
            int targetHashCode = 0;
            for (int i = 0; i < m; i++) {
                targetHashCode = (targetHashCode * 31 + target.charAt(i)) % BASE;
            }

            // get source hashCode
            int sourceHashCode = 0;
            for (int i = 0; i < source.length(); i++) {
                sourceHashCode = (sourceHashCode * 31 + source.charAt(i)) % BASE;

                // length < m
                if (i < m - 1) {
                    continue;
                }

                // length > m
                // move the first char
                if (i >= m) {
                    sourceHashCode = sourceHashCode - (source.charAt(i - m) * power) % BASE;

                    if (sourceHashCode < 0) {
                        sourceHashCode += BASE;
                    }
                }

                // length == m
                if (targetHashCode == sourceHashCode) {
                    if (source.substring(i - m + 1, i + 1).equals(target)) {
                        return i - m + 1;
                    }
                }
            }

            return -1;
        }
    }
}
