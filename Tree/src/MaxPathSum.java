/**
 * LC124
 * @author yanliu
 * @create 2021-01-25-15:50
 */
public class MaxPathSum {
    static class Solution {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMaxSum(root);

            return maxSum;
        }

        // get max of left and right subtree rooted in node
        private int getMaxSum(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = Math.max(getMaxSum(node.left), 0);
            int right = Math.max(getMaxSum(node.right), 0);

            maxSum = Math.max(maxSum, left + right + node.val);

            return Math.max(left, right) + node.val;
        }
    }
}
