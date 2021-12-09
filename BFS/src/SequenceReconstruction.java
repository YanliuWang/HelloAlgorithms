import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-31-9:18 PM
 */
public class SequenceReconstruction {
    class Solution {
        /**
         * @param org: a permutation of the integers from 1 to n
         * @param seqs: a list of sequences
         * @return: true if it can be reconstructed only one or false
         */
        public boolean sequenceReconstruction(int[] org, int[][] seqs) {
            // write your code here
            Map<Integer, Set<Integer>> graph = getGraph(seqs);

            List<Integer> topoOrder = topologicalSort(graph);

            if (topoOrder == null || topoOrder.size() != org.length) {
                return false;
            }

            for (int i = 0; i < org.length; i++) {
                if (org[i] != topoOrder.get(i)) {
                    return false;
                }
            }

            return true;
        }

        private Map<Integer, Set<Integer>> getGraph(int[][] seqs) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();

            for (int[] seq : seqs) {
                for (int i = 0; i < seq.length; i++) {
                    if (!graph.containsKey(seq[i])) {
                        graph.put(seq[i], new HashSet<>());
                    }
                }
            }



            for (int[] seq : seqs) {
                for (int i = 1; i < seq.length; i++) {
                    graph.get(seq[i - 1]).add(seq[i]);
                }
            }

            return graph;
        }

        private List<Integer> topologicalSort(Map<Integer, Set<Integer>> graph) {
            Map<Integer, Integer> indegrees = getIndegrees(graph);
            Queue<Integer> queue = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();

            for (Integer node : graph.keySet()) {
                // add the zero-indegree node
                if (!indegrees.containsKey(node)) {
                    queue.offer(node);
                }

                if (queue.size() > 1) {
                    return null;
                }
            }

            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                res.add(curr);

                for (Integer next : graph.get(curr)) {
                    indegrees.put(next, indegrees.get(next) - 1);

                    if (indegrees.get(next) == 0) {
                        queue.offer(next);

                        if (queue.size() > 1) {
                            return null;
                        }
                    }
                }
            }

            return res;
        }

        private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
            Map<Integer, Integer> indegrees = new HashMap<>();

            for (Integer node : graph.keySet()) {
                for (Integer next : graph.get(node)) {
                    indegrees.put(next, indegrees.getOrDefault(next, 0) + 1);
                }
            }

            return indegrees;
        }
    }
}
