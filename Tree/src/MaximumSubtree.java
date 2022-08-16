/**
 * LintCode628
 * @author yanliu
 * @create 2022-08-16-10:24 AM
 */
public class MaximumSubtree {
    static class Solution1 {
        private int max = Integer.MIN_VALUE;
        private TreeNode maxNode = null;

        /**
         * @param root: the root of binary tree
         * @return: the maximum weight node
         */
        public TreeNode findSubtree(TreeNode root) {
            // write your code here
            if (root == null) {
                return null;
            }

            dfs(root);

            return maxNode;

        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = dfs(root.left);
            int rightSum = dfs(root.right);

            int currSum = leftSum + rightSum + root.val;


            if (root.left != null && leftSum > max) {
                max = leftSum;
                maxNode = root.left;

            }

            if (root.right != null && rightSum > max) {
                max = rightSum;
                maxNode = root.right;
            }

            if (currSum > max) {
                max = currSum;
                maxNode = root;
            }

            return currSum;
        }
    }
}
