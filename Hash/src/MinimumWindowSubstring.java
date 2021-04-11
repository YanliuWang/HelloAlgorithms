/**LintCode 32
 * @author yanliu
 * @create 2021-04-11-20:54
 */
public class MinimumWindowSubstring {
    static class Solution {
        /**
         * @param source : A string
         * @param target: A string
         * @return: A string denote the minimum window, return "" if there is no such a string
         */
        public String minWindow(String source , String target) {
            char[] sourceArray = new char[256];
            char[] targetArray = new char[256];

            // fill the targe string to target array
            for (int i = 0; i < target.length(); i++) {
                targetArray[target.charAt(i)]++;
            }

            int start = 0, end = 0;
            int minStart = 0, minEnd = 0;
            int minLen = source.length() + 1;
            int counter = target.length();

            while (true) {
                if (end < source.length()) {
                    sourceArray[source.charAt(end)]++;

                    if (targetArray[source.charAt(end)] >= sourceArray[source.charAt(end)]) {
                        counter--;
                    }

                } else {
                    break;

                }

                if (counter == 0) {
                    // move the start to shorten the window size
                    while (sourceArray[source.charAt(start)] > targetArray[source.charAt(start)]) {
                        sourceArray[source.charAt(start)]--;
                        start++;
                    }

                    if (minLen > end - start + 1) {
                        minStart = start;
                        minEnd = end;
                        minLen = end - start + 1;
                    }
                }

                end++;
            }

            if (counter == 0) {
                return source.substring(minStart, minEnd + 1);
            }

            return "";
        }
    }
}
