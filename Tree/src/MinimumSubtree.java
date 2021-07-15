/**
 * LintCode 596
 * @author yanliu
 * @create 2021-07-15-9:24
 */
public class MinimumSubtree {
    static class Solution1 {
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

    static class Solution2 {
        class ResultType {
            // 最小子树根
            TreeNode minSubtree;

            int minSum, rootSum;

            public ResultType(TreeNode minSubtree, int minSum, int rootSum) {
                this.minSubtree = minSubtree;
                this.minSum = minSum;
                this.rootSum = rootSum;
            }
        }

        /**
         * @param root: the root of binary tree
         * @return: the root of the minimum subtree
         */
        public TreeNode findSubtree(TreeNode root) {
            // write your code here
            ResultType resultType = getResult(root);

            return resultType.minSubtree;
        }

        private ResultType getResult(TreeNode root) {
            if (root == null) {
                return new ResultType(null, Integer.MAX_VALUE, 0);
            }

            ResultType left = getResult(root.left);
            ResultType right = getResult(root.right);

            TreeNode minNode = root;
            int minSum = left.rootSum + right.rootSum + root.val;
            int currSum = minSum;

            if (left.minSum < minSum) {
                minSum = left.minSum;
                minNode = left.minSubtree;
            }

            if (right.minSum < minSum) {
                minSum = right.minSum;
                minNode = right.minSubtree;
            }

            return new ResultType(minNode, minSum, currSum);

        }
    }
}
