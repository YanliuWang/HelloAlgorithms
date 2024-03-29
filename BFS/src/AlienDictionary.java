import java.util.*;

/**
 * LeetCode269
 * @author yanliu
 * @create 2021-11-01-9:08 AM
 */
public class AlienDictionary {
    static class Solution1 {
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

    static class Solution2 {
        public String alienOrder(String[] words) {
            if (words == null || words.length == 0) {
                return "";
            }

            if (!isValid(words)) {
                return "";
            }

            Map<Character, Integer> nodeToIndegree = new HashMap<>();
            Map<Character, Set<Character>> graph = new HashMap<>();

            // initialize map
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    char key = words[i].charAt(j);

                    if (!nodeToIndegree.containsKey(key)) {
                        nodeToIndegree.put(key, 0);
                    }

                    if (!graph.containsKey(key)) {
                        graph.put(key, new HashSet<>());
                    }
                }
            }

            // construct the graph
            for (int i = 0; i < words.length - 1; i++) {
                int index = getFirstDiff(words[i], words[i + 1]);

                if (index == -1) {
                    continue;
                }

                char pre = words[i].charAt(index);
                char next = words[i + 1].charAt(index);

                if (graph.get(pre).contains(next)) {
                    continue;
                }

                graph.get(pre).add(next);
                nodeToIndegree.put(next, nodeToIndegree.get(next) + 1);
            }

            // traverse the graph
            Queue<Character> queue = new LinkedList<>();
            for (Character key : nodeToIndegree.keySet()) {
                if (nodeToIndegree.get(key) == 0) {
                    queue.offer(key);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {
                char curr = queue.poll();
                sb.append(curr);

                Set<Character> adj = graph.get(curr);

                // adjacent nodes' indegree - 1
                // offer 0-degree node to queue
                for (Character key : adj) {
                    nodeToIndegree.put(key, nodeToIndegree.get(key) - 1);

                    if (nodeToIndegree.get(key) == 0) {
                        queue.offer(key);
                    }
                }
            }

            if (sb.length() < nodeToIndegree.size()) {
                return "";
            }

            return sb.toString();
        }

        private int getFirstDiff(String str1, String str2) {
            int i = 0;

            while (i < str1.length() && i < str2.length()) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return i;
                }

                i++;
            }

            return -1;
        }

        private boolean isValid(String[] words) {
            for (int i = 0; i < words.length - 1; i++) {
                if (getFirstDiff(words[i], words[i + 1]) == -1
                        && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }

            return true;
        }
    }

    static class Solution3 {
        /**
         * @param words: a list of words
         * @return: a string which is correct order
         */
        public String alienOrder(String[] words) {
            // Write your code here
            if (words == null || words.length == 0) {
                return "";
            }

            Map<Character, Set<Character>> graph = buildGraph(words);

            if (graph == null) {
                return "";
            }

            Map<Character, Integer> inDegree = getInDegree(graph);

            PriorityQueue<Character> pq = new PriorityQueue<>();

            for (Character node : inDegree.keySet()) {
                if (inDegree.get(node) == 0) {
                    pq.offer(node);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!pq.isEmpty()) {
                char node = pq.poll();
                sb.append(node);

                for (Character adj : graph.get(node)) {
                    inDegree.put(adj, inDegree.get(adj) - 1);

                    if (inDegree.get(adj) == 0) {
                        pq.offer(adj);
                    }
                }
            }

            return sb.length() == graph.keySet().size() ? sb.toString() : "";
        }

        private Map<Character, Set<Character>> buildGraph(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();

            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char curr = word.charAt(i);

                    if (!graph.containsKey(curr)) {
                        graph.put(curr, new HashSet<>());
                    }

                }
            }

            for (int i = 0; i < words.length - 1; i++) {
                int idx = findFirstDiff(words[i], words[i + 1]);

                if (idx == -1) {
                    return null;
                }

                if (idx == Math.min(words[i].length(), words[i + 1].length())) {
                    continue;
                }

                char prev = words[i].charAt(idx);
                char next = words[i + 1].charAt(idx);

                graph.get(prev).add(next);
            }

            return graph;
        }

        private Map<Character, Integer> getInDegree(Map<Character, Set<Character>> graph) {
            Map<Character, Integer> inDegree = new HashMap<>();

            for (Character node : graph.keySet()) {
                if (!inDegree.containsKey(node)) {
                    inDegree.put(node, 0);
                }
            }

            for (Character node : graph.keySet()) {
                for (Character adj : graph.get(node)) {
                    inDegree.put(adj, inDegree.get(adj) + 1);
                }
            }

            return inDegree;
        }

        private int findFirstDiff(String str1, String str2) {
            int idx = 0;

            while (idx < str1.length() && idx < str2.length()) {
                if (str1.charAt(idx) != str2.charAt(idx)) {
                    break;
                }

                idx++;

            }

            if (idx == Math.min(str1.length(), str2.length())) {
                if (str1.length() > str2.length()) {
                    return -1;
                }
            }

            return idx;
        }
    }
}
