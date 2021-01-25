/**
 * @author yanliu
 * @create 2021-01-25-20:52
 */
public class DiameterOfBinaryTree {
    static class Solution {
        private int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getMaxDiameter(root);

            return res;
        }

        // the max diameter of left and right subtree rooted in node
        private int getMaxDiameter(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = getMaxDiameter(node.left);
            int right = getMaxDiameter(node.right);

            res = Math.max(res, left + right);

            return Math.max(left, right) + 1;
        }
    }
}
