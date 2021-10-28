import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-23-2:18 PM
 */
public class TopologicalSort {
    /**
     * Definition for Directed graph.
     *
     */
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
            if (graph == null || graph.size() == 0) {
                return new ArrayList<>();
            }

            Map<DirectedGraphNode, Integer> nodeToDegree = new HashMap<>();

            for (DirectedGraphNode node : graph) {
                for (DirectedGraphNode neighbor : node.neighbors) {
                    if (nodeToDegree.containsKey(neighbor)) {
                        nodeToDegree.put(neighbor, nodeToDegree.get(neighbor) + 1);
                    } else {
                        nodeToDegree.put(neighbor, 1);
                    }
                }
            }

            Queue<DirectedGraphNode> queue = new ArrayDeque<>();
            for (DirectedGraphNode node : graph) {
                if (!nodeToDegree.containsKey(node)) {
                    queue.offer(node);
                    nodeToDegree.put(node, 0);
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
