import java.util.*;

/**
 * LeetCode692
 * @author yanliu
 * @create 2022-05-11-9:59 PM
 */
public class TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            LinkedList<String> res = new LinkedList<>();

            if (words == null || words.length == 0) {
                return res;
            }

            Map<String, Integer> wordToFreq = new HashMap<>();
            for (String word : words) {
                wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
                return o1.getValue() == o2.getValue() ?
                        o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            });

            for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
                pq.offer(entry);

                if (pq.size() > k) {
                    pq.poll();
                }
            }

            while (!pq.isEmpty()) {
                res.add(0, pq.poll().getKey());
            }

            return res;

        }
    }
}
