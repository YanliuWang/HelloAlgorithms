import java.util.LinkedList;
import java.util.Queue;

/**
 * LC101
 * @author yanliu
 * @create 2021-01-01-22:58
 */
public class MinDepth {
    static class Solution1 {
        /**
         * DFS solution
         * go to the non-null child when either of the left and right child is null
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);

            if (left == 0) {
                return right + 1;

            } else if (right == 0){
                return left + 1;

            }

            return Math.min(left, right) + 1;
        }
    }

    static class Solution2 {
        /**
         * BFS solution, the first leaf node -> return level
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (curr.left == null && curr.right == null) {
                        return level;
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }

                }

                level++;

            }

            return level;
        }
    }
}
