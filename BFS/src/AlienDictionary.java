import java.util.*;

/**
 * @author yanliu
 * @create 2021-11-01-9:08 AM
 */
public class AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            if (words == null || words.length == 0) {
                return "";
            }

            return topoSortString(words);
        }

        private String topoSortString(String[] words) {
            Map<Character, Set<Character>> graph = getGraph(words);

            if (graph == null) {
                return "";
            }

            Map<Character, Integer> indegrees = getIndegrees(graph);

            PriorityQueue<Character> queue = new PriorityQueue<>();

            for (Character key : indegrees.keySet()) {
                if (indegrees.get(key) == 0) {
                    queue.offer(key);
                }
            }

            StringBuilder res = new StringBuilder();

            while (!queue.isEmpty()) {
                Character curr = queue.poll();
                res.append(curr);

                for (Character next : graph.get(curr)) {
                    indegrees.put(next, indegrees.get(next) - 1);

                    if (indegrees.get(next) == 0) {
                        queue.offer(next);
                    }
                }

            }

            return res.length() == indegrees.size() ? res.toString() : "";

        }

        private Map<Character, Set<Character>> getGraph(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();

            for (String word : words) {
                for (Character ch : word.toCharArray()) {
                    if (!graph.containsKey(ch)) {
                        graph.put(ch, new HashSet<>());
                    }
                }
            }


            for (int i = 0; i < words.length - 1; i++) {
                int index = 0;

                while (index < words[i].length() && index < words[i + 1].length()) {
                    if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                        graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                        // ******* why break *****
                        break;
                    }

                    index++;
                }

                if (index == Math.min(words[i].length(), words[i + 1].length())) {
                    if (words[i].length() > words[i + 1].length()) {
                        return null;
                    }
                }
            }

            return graph;
        }

        private Map<Character, Integer> getIndegrees(Map<Character, Set<Character>> graph) {
            Map<Character, Integer> indegrees = new HashMap<>();

            for (Character key : graph.keySet()) {
                // initialize the indegrees
                indegrees.put(key, 0);
            }

            for (Character key : graph.keySet()) {
                for (Character next : graph.get(key)) {
                    indegrees.put(next, indegrees.get(next) + 1);
                }
            }

            return indegrees;
        }
    }
}
