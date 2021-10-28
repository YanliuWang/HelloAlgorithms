import java.util.HashMap;
import java.util.Map;

/**
 * @author yanliu
 * @create 2021-10-16-3:48 PM
 */
public class MinimumWindowSubstring {
    public class Solution {
        /**
         * @param source : A string
         * @param target: A string
         * @return: A string denote the minimum window, return "" if there is no such a string
         */
        public String minWindow(String source , String target) {
            // write your code here
            if (source.length() == 0 || target.length() == 0) {
                return "";
            }

            // get the target Character to number set
            Map<Character, Integer> targetCounter = new HashMap<>();
            for (int i = 0; i < target.length(); i++) {
                int numOfChar = targetCounter.getOrDefault(target.charAt(i), 0);
                targetCounter.put(target.charAt(i), numOfChar + 1);
            }

            Map<Character, Integer> subCounter = new HashMap<>();
            int n = source.length();
            int matchedChars = 0;
            int minSubstrLen = Integer.MAX_VALUE;
            int right = 0;
            int start = 0;
            for (int left = 0; left < n; left++) {
                while (right < n && matchedChars < targetCounter.size()) {
                    subCounter.put(source.charAt(right), subCounter.getOrDefault(source.charAt(right), 0) + 1);

                    if (subCounter.get(source.charAt(right)).equals(targetCounter.get(source.charAt(right)))) {
                        matchedChars++;
                    }

                    right++;
                }

                if (matchedChars == targetCounter.size()) {
                    if (minSubstrLen > right - left) {
                        minSubstrLen = right - left;
                        start = left;
                    }
                }

                // remove the left character
                int numOfChar = subCounter.getOrDefault(source.charAt(left), 0);
                subCounter.put(source.charAt(left), numOfChar - 1);

                if (subCounter.get(source.charAt(left)).equals(targetCounter.getOrDefault(source.charAt(left), 0) - 1)) {
                    matchedChars--;
                }
            }

            if (minSubstrLen == Integer.MAX_VALUE) {
                return "";
            }

            return source.substring(start, start + minSubstrLen);
        }
    }
}
