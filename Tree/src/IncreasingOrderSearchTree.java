/**
 * LeetCode897
 * @author yanliu
 * @create 2022-04-17-11:28 PM
 */
public class IncreasingOrderSearchTree {
    static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            return dfs(root);
        }

        private TreeNode dfs(TreeNode root) {
            if (root == null) {
                return null;
            }

            if (root.left == null && root.right == null) {
                return root;
            }

            TreeNode left = dfs(root.left);
            root.left = null;

            TreeNode right = dfs(root.right);
            root.right = right;

            if (left == null) {
                return root;
            }

            TreeNode ptr = left;
            while (ptr.right != null) {
                ptr = ptr.right;
            }

            ptr.right = root;

            return left;
        }
    }
}
