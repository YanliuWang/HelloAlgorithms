/**
 * LC129
 * @author yanliu
 * @create 2021-01-16-14:40
 */
public class SumRootToLeafNumbers {
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

    static class Solution {
        private int sum = 0;

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }

            getSum(root, new StringBuilder());

            return sum;
        }

        private void getSum(TreeNode root, StringBuilder path) {
            path.append(root.val);

            if (root.left == null && root.right == null) {
                sum += Integer.parseInt(path.toString());
                path.deleteCharAt(path.length() - 1);

                return;
            }

            if (root.left != null) {
                getSum(root.left, path);
            }

            if (root.right != null) {
                getSum(root.right, path);
            }

            path.deleteCharAt(path.length() - 1);
        }
    }
}
