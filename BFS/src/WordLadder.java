import java.util.*;

/**
 * LeetCode127
 * @author yanliu
 * @create 2021-03-31-23:42
 */
public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // convert list to set
            Set<String> dict = new HashSet<>(wordList);
            Queue<String> queue = new LinkedList<>();
            // record visited words
            Set<String> visited = new HashSet<>(wordList.size());

            queue.offer(beginWord);
            visited.add(beginWord);

            // length from begin word to end word
            int length = 1;

            while (!queue.isEmpty()) {
                // to next word length
                length++;

                // record current level size
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String currWord = queue.poll();
                    List<String> nextWords = getNextWords(currWord, dict);

                    for (String nextWord : nextWords) {
                        // check duplication
                        if (visited.contains(nextWord)) {
                            continue;
                        }

                        if (endWord.equals(nextWord)) {
                            return length;
                        }

                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }

            return 0;
        }

        private List<String> getNextWords(String currWord, Set<String> wordList) {
            List<String> nextWords = new LinkedList<>();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < currWord.length(); i++) {
                    if (currWord.charAt(i) != ch) {
                        // replace i-th char in currWord to ch
                        String word = replace(currWord, i, ch);

                        if (wordList.contains(word)) {
                            nextWords.add(word);
                        }
                    }
                }
            }

            return nextWords;
        }

        // replace char at position index in word to ch
        private String replace(String word, int index, char ch) {
            char[] charArray = word.toCharArray();
            charArray[index] = ch;

            return new String(charArray);
        }
    }
}
