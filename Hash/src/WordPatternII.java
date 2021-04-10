import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yanliu
 * @create 2021-04-10-18:54
 */
public class WordPatternII {
    static class Solution {
        /**
         * @param pattern: a string,denote pattern string
         * @param str: a string, denote matching string
         * @return: a boolean
         */
        public boolean wordPatternMatch(String pattern, String str) {
            // write your code here
            if (pattern == null || str == null) {
                return false;
            }

            Map<Character, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();

            return dfs(pattern, 0, str, 0, map, set);
        }

        private boolean dfs(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
            if (i == pattern.length() && j == str.length()) {
                return true;
            }

            if (i == pattern.length() || j == str.length()) {
                return false;
            }

            char p = pattern.charAt(i);

            if (map.containsKey(p)) {
                String word = map.get(p);

                if (!str.startsWith(word, j)) {
                    return false;
                } else {
                    return dfs(pattern, i + 1, str, j + word.length(), map, set);
                }
            }

            // map does not contain the key-pattern
            for (int k = j; k < str.length(); k++) {
                String word = str.substring(j, k + 1);

                if (set.contains(word)) {
                    continue;
                }

                map.put(p, word);
                set.add(word);

                if (dfs(pattern, i + 1, str, k + 1, map, set)) {
                    return true;
                }

                map.remove(p);
                set.remove(word);
            }

            return false;

        }
    }
}
