/**
 * @author yanliu
 * @create 2020-12-16-17:06
 */
public class KthSmallest {
    static class Solution {
        private int res = 0;
        private int count = 0;

        public int kthSmallest(TreeNode root, int k) {
            count = k;

            helper(root);

            return res;
        }

        private void helper(TreeNode root) {
            if (root.left != null) {
                helper(root.left);
            }

            if (--count == 0) {
                res = root.val;
            }

            if (root.right != null) {
                helper(root.right);
            }
        }
    }
}
