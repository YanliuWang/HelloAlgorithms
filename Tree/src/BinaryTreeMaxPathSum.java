/**
 * LC124
 * @author yanliu
 * @create 2021-01-25-15:50
 */
public class BinaryTreeMaxPathSum {
    static class Solution {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }

            getMaxBranchSum(root);

            return maxSum;
        }

        /**
         * get max of left and right subtree rooted in node
         * root must be used
         * only one sub-node of root can be used
         * @param root
         * @return
         */
        private int getMaxBranchSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = getMaxBranchSum(root.left);
            int right = getMaxBranchSum(root.right);

            int maxBranchSum = root.val + Math.max(0, Math.max(left, right));

            maxSum = Math.max(maxSum, Math.max(maxBranchSum, root.val + left + right));

            return maxBranchSum;
        }
    }
}
