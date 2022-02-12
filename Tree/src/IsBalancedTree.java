/**
 * LeetCode110
 * @author yanliu
 * @create 2021-12-25-12:04 PM
 */
public class IsBalancedTree {
    /**
     * top-down recursion
     */
    static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2
                    && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    /**
     * bottom-up recursion
     */
    static class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = getHeight(root.left);
            int right = getHeight(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                // -1 flag
                // the tree is unbalanced
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }
}
