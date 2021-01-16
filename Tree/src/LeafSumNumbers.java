/**
 * LC129
 * @author yanliu
 * @create 2021-01-16-14:40
 */
public class LeafSumNumbers {
    static class Solution1 {
        public int sumNumbers(TreeNode root) {
            return getSum(root, 0);
        }

        private int getSum(TreeNode node, int currSum) {
            if (node == null) {
                return 0;
            }

            currSum = currSum * 10 + node.val;

            if (node.left == null && node.right == null) {
                return currSum;
            }

            return getSum(node.left, currSum) + getSum(node.right, currSum);
        }
    }
}
