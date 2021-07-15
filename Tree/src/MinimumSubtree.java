/**
 * LintCode 596
 * @author yanliu
 * @create 2021-07-15-9:24
 */
public class MinimumSubtree {
    static class Solution {
        // record root node with minimum sum
        private TreeNode minRoot;

        // record the minimum sum
        private int minSum;

        public TreeNode findSubtree(TreeNode root) {
            if (root == null) {
                return null;
            }

            // initialization
            minSum = Integer.MAX_VALUE;
            minRoot = null;

            getMinSum(root);

            return minRoot;
        }

        // 1.definition : return min sum; get min root during the process
        private int getMinSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = getMinSum(root.left);
            int rightSum = getMinSum(root.right);
            int rootSum = leftSum + rightSum + root.val;

            if (rootSum < minSum) {
                minSum = rootSum;
                minRoot = root;
            }

            return minSum;
        }
    }
}
