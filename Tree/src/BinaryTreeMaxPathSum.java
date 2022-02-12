/**
 * LC124
 * @author yanliu
 * @create 2021-01-25-15:50
 */
public class BinaryTreeMaxPathSum {
    static class Solution1 {
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

    static class Solution2 {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            maxBranchSum(root);

            return maxSum;
        }

        private int maxBranchSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = Math.max(0, maxBranchSum(root.left));
            int rightSum = Math.max(0, maxBranchSum(root.right));
            int maxBranchSum = root.val + Math.max(leftSum, rightSum);

            maxSum = Math.max(maxSum,
                    Math.max(maxBranchSum, root.val + leftSum + rightSum));

            return maxBranchSum;


        }
    }
}
