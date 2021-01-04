/**
 * LC965
 * @author yanliu
 * @create 2021-01-04-10:29
 */
public class IsUnivalueTree {
    static class Solution {
        private int val;

        public boolean isUnivalueTree(TreeNode root) {
            val = root.val;

            return dfs(root);
        }

        private boolean dfs(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (root.val != val) {
                return false;
            }

            return dfs(root.left) && dfs(root.right);
        }
    }
}
