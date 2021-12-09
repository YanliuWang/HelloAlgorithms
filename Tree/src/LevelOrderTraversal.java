import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 102
 * @author yanliu
 * @create 2020-11-01-13:22
 */
public class LevelOrderTraversal {
    static class Solution1 {
        public List<List<Integer>> levelOrderTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            // the difference between add() and offer()
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                res.add(level);
            }

            return res;
        }

    }

    /**
     * using two queue
     */
    static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                res.add(toIntegerList(queue));
                List<TreeNode> nextQueue = new ArrayList<>();

                for (int i = 0; i < queue.size(); i++) {
                    TreeNode curr = queue.get(i);

                    if (curr.left != null) {
                        nextQueue.add(curr.left);
                    }

                    if (curr.right != null) {
                        nextQueue.add(curr.right);
                    }
                }

                queue = nextQueue;
            }

            return res;
        }

        private List<Integer> toIntegerList(List<TreeNode> queue) {
            List<Integer> res = new LinkedList<>();

            for (TreeNode node : queue) {
                res.add(node.val);
            }

            return res;
        }
    }
}
