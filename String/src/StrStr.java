/**
 * @author yanliu
 * @create 2021-06-29-11:02
 */
public class StrStr {
    /**
     * O(n^2) solution
     * n is the length of needle
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
        public int strStr(String source, String target) {
            // write your code here
            if (source == null && target == null) {
                return 0;
            }

            // except boundary situations
            if (source == null || target == null) {
                return -1;
            }

            int sourceLength = source.length();
            int targetLength = target.length();

            if (targetLength == 0) {
                return 0;
            }

            if (sourceLength < targetLength) {
                return -1;
            }

            // get target hashcode
            int targetHashCode = 0;
            for (int i = 0; i < targetLength; i++) {
                targetHashCode = (targetHashCode * 31 + target.charAt(i)) % BASE;
            }

            // get power for removing
            int power = 1;
            for (int i = 0; i < targetLength; i++) {
                power = (power * 31) % BASE;
            }

            // get source hashcode
            int sourceHashCode = 0;
            for (int i = 0; i < sourceLength; i++) {
                sourceHashCode = (sourceHashCode * 31 + source.charAt(i)) % BASE;

                // the included string length is less than target Length
                // continue to calculate the hashcode
                if (i < targetLength - 1) {
                    continue;
                }

                // the included string length is more than target length
                // remove the first character hashcode
                if (i >= targetLength) {
                    sourceHashCode = sourceHashCode - (source.charAt(i - targetLength) * power) % BASE;

                    if (sourceHashCode < 0) {
                        sourceHashCode += BASE;
                    }
                }

                // the included string length is as same as the target length
                if (targetHashCode == sourceHashCode) {
                    if (source.substring(i - targetLength + 1, i + 1).equals(target)) {
                        return i - targetLength + 1;
                    }
                }
            }

            return -1;

        }
    }
}
