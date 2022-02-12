import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-12-23-8:34 PM
 */
public class NAryTreeTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    /**
     * LeetCode429
     */
    static class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> subRes = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    subRes.add(curr.val);

                    for (Node child : curr.children) {
                        queue.offer(child);
                    }
                }

                res.add(subRes);
            }

            return res;

        }
    }

    /**
     * LeetCode429
     */
    static class Solution2 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            List<Node> currQueue = new ArrayList<>();
            currQueue.add(root);

            while (!currQueue.isEmpty()) {
                res.add(toIntegerList(currQueue));

                List<Node> nextQueue = new ArrayList<>();

                for (int i = 0; i < currQueue.size(); i++) {
                    Node curr = currQueue.get(i);

                    for (Node node : curr.children) {
                        nextQueue.add(node);
                    }
                }

                currQueue = nextQueue;
            }

            return res;
        }

        private List<Integer> toIntegerList(List<Node> nodeList) {
            List<Integer> res = new ArrayList<>();

            for (Node node : nodeList) {
                res.add(node.val);
            }

            return res;
        }
    }

    /**
     * LeetCode589
     */
    static class Solution3 {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            dfs(root, res);

            return res;
        }

        private void dfs(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }

            res.add(root.val);

            for (Node child : root.children) {
                dfs(child, res);
            }
        }
    }

    /**
     * LeetCode590
     */
    static class Solution4 {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();

            dfs(root, res);

            return res;
        }

        private void dfs(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }

            for (Node child : root.children) {
                dfs(child, res);
            }

            res.add(root.val);
        }
    }
}
