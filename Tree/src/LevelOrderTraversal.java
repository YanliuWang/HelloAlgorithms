import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
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

    static class Solution2 {
        public void levelOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();

                if (curr == null) {
                    continue;
                }

                queue.offer(curr.left);
                queue.offer(curr.right);
            }

        }
    }
}
