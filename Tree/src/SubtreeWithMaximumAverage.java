/**
 * @author yanliu
 * @create 2022-08-22-12:14 AM
 */
public class SubtreeWithMaximumAverage {
    static class Solution {
        private TreeNode maxNode = null;
        private double maxAvg = -Double.MAX_VALUE;
        /**
         * @param root: the root of binary tree
         * @return: the root of the maximum average of subtree
         */
        public TreeNode findSubtree2(TreeNode root) {
            // write your code here
            dfs(root);

            return maxNode;
        }

        private double[] dfs(TreeNode curr) {
            if (curr == null) {
                return new double[2];
            }

            double[] left = dfs(curr.left);
            double[] right = dfs(curr.right);

            double nodes = left[1] + right[1] + 1;
            double avg = (left[0] * left[1] + right[0] * right[1] + curr.val) / nodes;

            if (avg > maxAvg) {
                maxAvg = avg;
                maxNode = curr;
            }

            return new double[]{avg, nodes};

        }
    }
}
