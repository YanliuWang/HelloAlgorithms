import java.util.*;

/**
 * leetcode 133
 * @author yanliu
 * @create 2021-07-09-9:02
 */
public class CloneGraph {
    static class Solution {
        class UndirectedGraphNode {
            public int val;
            public List<UndirectedGraphNode> neighbors;

            public UndirectedGraphNode(int val) {
                this.val = val;
            }

            public UndirectedGraphNode(int val, List<UndirectedGraphNode> neighbors) {
                this.val = val;
                this.neighbors = new ArrayList<>();
            }
        }

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) {
                return null;
            }

            // 1. find all nodes from original graph
            List<UndirectedGraphNode> nodes = findNodesByBFS(node);

            // 2. copy all new nodes based on original nodes
            Map<UndirectedGraphNode, UndirectedGraphNode> mapping = copyNodes(nodes);

            // 3.copy edges
            copyEdges(nodes, mapping);

            // return new head
            return mapping.get(node);
        }

        private List<UndirectedGraphNode> findNodesByBFS(UndirectedGraphNode node) {
            Queue<UndirectedGraphNode> queue = new LinkedList<>();
            // set is used to remove duplicates
            Set<UndirectedGraphNode> visited = new HashSet<>();

            queue.offer(node);
            visited.add(node);

            while (!queue.isEmpty()) {
                UndirectedGraphNode currNode = queue.poll();

                for (UndirectedGraphNode neighbor : currNode.neighbors) {
                    // check duplication
                    if (visited.contains(neighbor)) {
                        continue;
                    }

                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }

            // return the list
            return new ArrayList<>(visited);
        }

        private Map<UndirectedGraphNode, UndirectedGraphNode> copyNodes(List<UndirectedGraphNode> nodes) {
            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(nodes.size());

            for (UndirectedGraphNode node : nodes) {
                map.put(node, new UndirectedGraphNode(node.val));
            }

            return map;
        }

        private void copyEdges(List<UndirectedGraphNode> nodes, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
            for (UndirectedGraphNode oldNode : nodes) {
                // shallow reference copy
                UndirectedGraphNode newNode = map.get(oldNode);

                for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                    newNode.neighbors.add(map.get(oldNeighbor));
                }
            }
        }
    }

}
