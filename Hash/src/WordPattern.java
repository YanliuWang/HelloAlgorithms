import java.util.HashMap;
import java.util.Map;

/**
 * LC290
 * @author yanliu
 * @create 2021-04-10-17:14
 */
public class WordPattern {
    static class Solution {
        /**
         * @param pattern: a string, denote pattern string
         * @param teststr: a string, denote matching string
         * @return: an boolean, denote whether the pattern string and the matching string match or not
         */
        public boolean wordPattern(String pattern, String teststr) {
            if (teststr == null || pattern == null) {
                return false;
            }

            String[] words = teststr.split(" ");

            if (pattern.length() != words.length) {
                return false;
            }

            Map<Character, String> charToStr = new HashMap<>();
            Map<String, Character> strToChar = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                char p = pattern.charAt(i);
                String word = words[i];

                if (charToStr.containsKey(p)) {
                    if (!charToStr.get(p).equals(word)) {
                        return false;
                    }
                } else {
                    charToStr.put(p, word);
                }

                if (strToChar.containsKey(word)) {
                    if (!strToChar.get(word).equals(p)) {
                        return false;
                    }
                } else {
                    strToChar.put(word, p);
                }
            }

            return true;
        }
    }
}
