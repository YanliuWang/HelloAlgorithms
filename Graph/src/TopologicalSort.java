import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-31-6:15 PM
 */
public class TopologicalSort {
     class DirectedGraphNode {
         int label;
         List<DirectedGraphNode> neighbors;
         DirectedGraphNode(int x) {
             label = x;
             neighbors = new ArrayList<DirectedGraphNode>();
         }
     }


    public class Solution {
        /**
         * @param graph: A list of Directed graph node
         * @return: Any topological order for the given graph.
         */
        public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
            // write your code here
            Map<DirectedGraphNode, Integer> nodeToDegree = new HashMap<>();

            for (DirectedGraphNode node : graph) {
                for (DirectedGraphNode neighbor : node.neighbors) {
                    nodeToDegree.put(neighbor, nodeToDegree.getOrDefault(neighbor, 0) + 1);
                }
            }

            Queue<DirectedGraphNode> queue = new ArrayDeque<>();

            for (DirectedGraphNode node : graph) {
                // offer all the 0-indegree node to queue
                if (!nodeToDegree.containsKey(node)) {
                    queue.offer(node);
                }
            }

            ArrayList<DirectedGraphNode> res = new ArrayList<>();

            while (!queue.isEmpty()) {
                DirectedGraphNode curr = queue.poll();
                res.add(curr);

                for (DirectedGraphNode neighbor : curr.neighbors) {
                    nodeToDegree.put(neighbor, nodeToDegree.get(neighbor) - 1);

                    if (nodeToDegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            return res;
        }
    }
}
