/**
 * @author yanliu
 * @create 2020-12-14-14:1
 * using postOrder traverse the binary tree
 * from bottom to top
 */

public class LowestCommonAncestor {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // p and q are both not in root tree
            // return null
            if (left == null && right == null) {
                return null;
            }

            // p and q are both in root tree
            // return the root
            if (left != null && right != null) {
                return root;
            }

            // return the non-null node
            return left == null ? right : left;
        }
    }
}
