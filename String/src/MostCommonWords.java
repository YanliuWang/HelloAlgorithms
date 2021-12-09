import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 819
 * @author yanliu
 * @create 2021-11-15-8:52 PM
 */
public class MostCommonWords {
    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            // match non-word symbol
            // W in upper case means non-word
            // w in lower case means word

            String[] words = paragraph.split("\\W+");
            Set<String> bannedWords = new HashSet<>();
            Map<String, Integer> wordToFreq = new HashMap<>();

            for (String bannedWord : banned) {
                bannedWords.add(bannedWord);
            }

            for (String word : words) {
                if ("".equals(word)) {
                    continue;
                }

                word = word.toLowerCase();

                if (bannedWords.contains(word)) {
                    continue;
                }

                wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
            }

            int maxFreq = 0;
            String word = "";

            for (String key : wordToFreq.keySet()) {
                if (wordToFreq.get(key) > maxFreq) {
                    maxFreq = wordToFreq.get(key);
                    word = key;
                }
            }

            return word;


        }
    }
}
