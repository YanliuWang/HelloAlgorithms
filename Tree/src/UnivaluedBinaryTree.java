/**
 * LeetCode965
 * @author yanliu
 * @create 2021-12-25-4:59 PM
 */
public class UnivaluedBinaryTree {
    static class Solution1 {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);

        }

        private boolean isUnivalTree(TreeNode root, int val) {
            if (root == null) {
                return true;
            }

            if (root.val != val) {
                return false;
            }

            return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);

        }
    }

    static class Solution2 {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }

            boolean left = root.left == null
                    || (root.left.val == root.val && isUnivalTree(root.left));

            boolean right = root.right == null
                    || (root.right.val == root.val && isUnivalTree(root.right));

            return left && right;
        }
    }
}
