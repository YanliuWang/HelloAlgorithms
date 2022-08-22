import java.util.*;

/**
 * 判断是否有多个拓扑排序
 * @author yanliu
 * @create 2021-10-31-9:18 PM
 */
public class SequenceReconstruction {
    public class Solution {
        /**
         * @param org: a permutation of the integers from 1 to n
         * @param seqs: a list of sequences
         * @return: true if it can be reconstructed only one or false
         */
        public boolean sequenceReconstruction(int[] org, int[][] seqs) {
            // write your code here
            if (org == null || org.length == 0) {
                return true;
            }

            Map<Integer, Set<Integer>> graph = buildGraph(seqs);
            Map<Integer, Integer> nodeToIndegree = getIndegree(graph);

            int[] seq = topoSort(graph, nodeToIndegree);

            if (seq.length != org.length) {
                return false;
            }

            for (int i = 0; i < seq.length; i++) {
                if (seq[i] != org[i]) {
                    return false;
                }
            }

            return true;
        }

        private Map<Integer, Set<Integer>> buildGraph(int[][] seqs) {
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

        private Map<Integer, Integer> getIndegree(Map<Integer, Set<Integer>> graph) {
            Map<Integer, Integer> nodeToIndegree = new HashMap<>();

            for (Integer node : graph.keySet()) {
                if (!nodeToIndegree.containsKey(node)) {
                    nodeToIndegree.put(node, 0);
                }
            }

            for (Integer node : graph.keySet()) {
                for (Integer adj : graph.get(node)) {
                    nodeToIndegree.put(adj, nodeToIndegree.get(adj) + 1);
                }
            }

            return nodeToIndegree;
        }

        private int[] topoSort(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> nodeToIndegree) {
            Queue<Integer> queue = new ArrayDeque<>();

            for (Integer node : nodeToIndegree.keySet()) {
                if (nodeToIndegree.get(node) == 0) {
                    queue.offer(node);
                }
            }

            int[] res = new int[nodeToIndegree.size()];
            int idx = 0;

            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    return new int[0];
                }

                int node = queue.poll();
                res[idx++] = node;

                for (Integer adj : graph.get(node)) {
                    nodeToIndegree.put(adj, nodeToIndegree.get(adj) - 1);

                    if (nodeToIndegree.get(adj) == 0) {
                        queue.offer(adj);
                    }
                }
            }

            return res;
        }
    }
}
