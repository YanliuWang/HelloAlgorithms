import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1048
 * @author yanliu
 * @create 2021-11-20-9:38 PM
 */
public class LongestStringChain {
    static class Solution {
        public int longestStrChain(String[] words) {
            if (words == null || words.length == 0) {
                return 0;
            }

            Map<String, Integer> dp = new HashMap<>();
            Arrays.sort(words, new Comparator<String>() {
                public int compare(String a, String b) {
                    return a.length() - b.length();
                }
            });

            int longestAll = 0;

            for (String word : words) {
                int longestCurr = 0;

                // remove one character from the word
                // check the previous string
                for (int i = 0; i < word.length(); i++) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    longestCurr = Math.max(longestCurr, dp.getOrDefault(prev, 0) + 1);
                }

                dp.put(word, longestCurr);
                longestAll = Math.max(longestCurr, longestAll);
            }

            return longestAll;
        }
    }
}
