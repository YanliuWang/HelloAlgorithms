import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode1002
 * @author yanliu
 * @create 2022-05-12-4:42 PM
 */
public class FindCommonCharacters {
    class Solution {
        public List<String> commonChars(String[] words) {
            List<String> res = new ArrayList<>();

            if (words == null || words.length == 0) {
                return res;
            }

            int[] charSet = new int[26];
            Arrays.fill(charSet, Integer.MAX_VALUE);

            for (String word : words) {
                int[] count = getCount(word);

                for (int i = 0; i < 26; i++) {
                    charSet[i] = Math.min(charSet[i], count[i]);
                }
            }

            for (int i = 0; i < charSet.length; i++) {
                for (int sz = charSet[i]; sz > 0; sz--) {
                    res.add(Character.toString(i + 'a'));
                }
            }

            return res;
        }

        private int[] getCount(String word) {
            int[] count = new int[26];

            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }

            return count;
        }
    }
}
