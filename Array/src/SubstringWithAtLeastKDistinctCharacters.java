import java.util.HashMap;
import java.util.Map;

/**
 * @author yanliu
 * @create 2021-10-14-11:19 AM
 */
public class SubstringWithAtLeastKDistinctCharacters {
    class Solution {
        /**
         * @param s: a string
         * @param k: an integer
         * @return: the number of substrings there are that contain at least k distinct characters
         */
        public long kDistinctCharacters(String s, int k) {
            // Write your code here
            if (s == null || s.length() < k) {
                return 0;
            }

            long numSubstring = 0;
            Map<Character, Integer> counters = new HashMap<>();
            int numOfDistChars = 0;
            int n = s.length();

            int right = 0;
            for (int left = 0; left < n; left++) {
                while (right < n && numOfDistChars < k) {
                    counters.put(s.charAt(right), counters.getOrDefault(s.charAt(right), 0) + 1);

                    if (counters.get(s.charAt(right)) == 1) {
                        numOfDistChars++;
                    }

                    right++;
                }

                if (numOfDistChars >= k) {
                    numSubstring += n - right + 1;
                }

                counters.put(s.charAt(left), counters.get(s.charAt(left)) - 1);

                if (counters.get(s.charAt(left)) == 0) {
                    numOfDistChars--;
                }
            }

            return numSubstring;
        }
    }
}
