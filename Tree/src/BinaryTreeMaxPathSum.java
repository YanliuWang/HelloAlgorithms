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

            oneSideSum(root);

            return maxSum;
        }

        /**
         * get max of left and right subtree rooted in node
         * root must be used
         * only one sub-node of root can be used
         * @param root
         * @return
         */
        private int oneSideSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // abandon the negative value
            int leftSide = Math.max(0, oneSideSum(root.left));
            int rightSide = Math.max(0, oneSideSum(root.right));

            // update the maxSum if it is necessary
            maxSum = Math.max(maxSum, leftSide + rightSide + root.val);

            return Math.max(leftSide, rightSide) + root.val;
        }
    }
}
