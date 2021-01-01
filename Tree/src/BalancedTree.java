/**
 * @author yanliu
 * @create 2021-01-01-12:13
 */
public class BalancedTree {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
