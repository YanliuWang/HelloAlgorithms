import java.util.*;

/**
 * LeetCode127
 * @author yanliu
 * @create 2021-03-31-23:42
 */
public class WordLadder {
    /**
     * word ladder 1
     */
    class Solution1 {
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
                    if (currWord.charAt(i) == ch) {
                        continue;
                    }

                    // replace i-th char in currWord to ch
                    String word = replace(currWord, i, ch);

                    if (wordList.contains(word)) {
                        continue;
                    }

                    nextWords.add(word);


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

    /**
     * word ladder 2
     */
    class Solution2 {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Map<String, Integer> distanceToStart = new HashMap<>();
            Set<String> dict = new HashSet<>(wordList);

            // using bfs to construct graph
            Map<String, Set<String>> graph = getGraph(beginWord, endWord, distanceToStart, dict);

            List<List<String>> res = new ArrayList<>();
            List<String> subRes = new ArrayList<>();

            // using dfs to find ladders
            findLadders(beginWord, endWord, graph, subRes, res);

            return res;
        }

        private Map<String, Set<String>> getGraph(String beginWord, String endWord,
                                                  Map<String, Integer> distanceToStart, Set<String> dict) {

            Map<String, Set<String>> graph = new HashMap<>();
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            distanceToStart.put(beginWord, 0);

            boolean endIsFound = false;

            while (!queue.isEmpty() && !endIsFound) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String currWord = queue.poll();
                    Set<String> nextWords = getNextWords(currWord, dict);
                    Iterator<String> nextWordsIterator = nextWords.iterator();

                    while (nextWordsIterator.hasNext()) {
                        String nextWord = nextWordsIterator.next();

                        if (nextWord.equals(endWord)) {
                            endIsFound = true;
                        }

                        if (distanceToStart.containsKey(nextWord)) {
                            if (distanceToStart.get(nextWord) != distanceToStart.get(currWord) + 1) {
                                // abondon it because it is not the shorest path
                                nextWordsIterator.remove();
                            }

                        } else {
                            queue.offer(nextWord);
                            distanceToStart.put(nextWord, distanceToStart.get(currWord) + 1);

                        }

                    }

                    graph.put(currWord, nextWords);
                }
            }

            return graph;

        }

        private Set<String> getNextWords(String currWord, Set<String> dict) {
            Set<String> nextWords = new HashSet<>();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < currWord.length(); i++) {
                    if (currWord.charAt(i) == ch) {
                        continue;
                    }

                    String nextWord = replace(currWord, i, ch);

                    if (!dict.contains(nextWord)) {
                        continue;
                    }

                    nextWords.add(nextWord);
                }
            }

            return nextWords;
        }

        private String replace(String currWord, int index, char ch) {
            char[] str = currWord.toCharArray();
            str[index] = ch;
            return new String(str);
        }

        private void findLadders(String beginWord, String endWord, Map<String, Set<String>> graph, List<String> subRes, List<List<String>> res) {
            subRes.add(beginWord);

            if (beginWord.equals(endWord)) {
                res.add(new ArrayList<>(subRes));
            }

            if (graph.containsKey(beginWord)) {
                for (String nextWord : graph.get(beginWord)) {
                    findLadders(nextWord, endWord, graph, subRes, res);
                }
            }

            subRes.remove(subRes.size() - 1);

        }


    }
}
