/**
 * LC110
 * @author yanliu
 * @create 2021-01-01-12:13
 */
public class BalancedTree {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }
}
