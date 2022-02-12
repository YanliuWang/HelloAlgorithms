import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode513
 * @author yanliu
 * @create 2021-03-24-23:12
 */
public class FindLeftBottom {
    /**
     * using bfs
     */
    static class Solution1 {
        public int findBottomLeftValue(TreeNode root) {
            // judge whether the current node is the first node
            boolean isFirst = false;
            Queue<TreeNode> queue = new LinkedList<>();
            int leftValue = 0;

            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                isFirst = true;

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (isFirst) {
                        leftValue = curr.val;
                        isFirst = false;
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }

            }

            return leftValue;
        }
    }

    /**
     * using dfs
     */
    static class Solution2 {
        private int maxDepth = 0;
        private int value = 0;

        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 1);

            return value;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }

            if (depth > maxDepth) {
                value = root.val;
                maxDepth = depth;
            }

            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
