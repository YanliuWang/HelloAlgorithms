/**
 * LeetCode 1373
 * @author yanliu
 * @create 2021-11-27-8:39 PM
 */
public class MaxSumBST {
    static class Solution {
        private int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            // res[0]: 1 -> isBST, 0 -> isNotBST
            // res[1]: min value of curr node
            // res[2]: max value of curr node
            // res[3]: curr sum
            int[] res = getMax(root);

            return maxSum;
        }

        private int[] getMax(TreeNode root) {
            if (root == null) {
                return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }

            int[] left = getMax(root.left);
            int[] right = getMax(root.right);

            int[] res = new int[4];

            if (left[0] == 1 && right[0] == 1
                    && root.val > left[2] && root.val < right[1]) {
                res[0] = 1;
                res[1] = Math.min(left[1], root.val);
                res[2] = Math.max(right[2], root.val);
                res[3] = left[3] + right[3] + root.val;

                maxSum = Math.max(maxSum, res[3]);

            } else {
                res[0] = 0;
            }

            return res;
        }
    }
}
