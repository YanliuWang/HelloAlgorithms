import java.util.*;

/**
 * LC127
 * @author yanliu
 * @create 2021-03-31-23:42
 */
public class WordLadder {
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>();
            for (String word : wordList) {
                wordSet.add(word);
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int distance = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                distance++;

                for (int i = 0; i < size; i++) {
                    String top = queue.poll();

                    List<String> wordsWithinDistance = getWordsWithinDistance(top, wordSet);

                    for (String word : wordsWithinDistance) {
                        if (word.equals(endWord)) {
                            return distance;
                        }

                        if (!visited.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                }
            }

            return 0;
        }

        private List<String> getWordsWithinDistance(String word, Set<String> wordSet) {
            char[] charArray = word.toCharArray();
            List<String> res = new ArrayList<>();

            for (int i = 0; i < charArray.length; i++) {
                char original = charArray[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) {
                        continue;
                    }

                    charArray[i] = c;

                    String transformedWord = new String(charArray);

                    if (wordSet.contains(transformedWord)) {
                        res.add(transformedWord);
                    }
                }

                charArray[i] = original;
            }

            return res;
        }
    }
}
