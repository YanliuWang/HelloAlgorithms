import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode104
 * @author yanliu
 * @create 2020-11-02-10:49
 */
public class MaxDepth {
    /**
     * iteration
     */
    static class Solution1 {
        public int maxDepthIteration(TreeNode root) {
            if (root == null) {
                return 0;

            }

            Deque<Integer> depthStack = new ArrayDeque<>();
            Deque<TreeNode> treeNodeStack = new ArrayDeque<>();
            TreeNode curr = root;
            int max = 0, depth = 1;

            while (curr != null || !treeNodeStack.isEmpty()) {
                while (curr != null) {
                    depthStack.addFirst(depth);
                    treeNodeStack.add(curr);

                    depth++;
                    curr = curr.left;

                }

                curr = treeNodeStack.removeFirst();
                depth = depthStack.removeFirst();

                if (depth > max) {
                    max = depth;
                }

                depth++;
                curr = curr.right;
            }

            return max;
        }
    }

    /**
     * bottom-up recursion
     */
    static class Solution2 {
        public int maxDepthBottomUp(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepthBottomUp(root.left);
            int rightDepth = maxDepthBottomUp(root.right);

            return Math.max(leftDepth, rightDepth) + 1;

        }
    }

    /**
     * top-down recursion
     */
    static class solution3 {
        private int res;

        public int maxDepthTopDown(TreeNode root) {
            getMaxDepth(root, 1);
            return res;

        }

        private void getMaxDepth(TreeNode root, int depth) {
            if (root == null) {
                return;
            }

            if (root.left == null || root.right == null) {
                res = Math.max(res, depth);
            }

            getMaxDepth(root.left, depth + 1);
            getMaxDepth(root.right, depth + 1);
        }

    }

}
