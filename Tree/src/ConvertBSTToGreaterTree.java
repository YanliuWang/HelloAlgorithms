/**
 * LeetCode538
 * @author yanliu
 * @create 2021-11-11-9:43 AM
 */
public class ConvertBSTToGreaterTree {
    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            convert(root, new int[1]);

            return root;
        }

        private void convert(TreeNode root, int[] sum) {
            if (root == null) {
                return;
            }

            convert(root.right, sum);

            sum[0] += root.val;
            root.val = sum[0];

            convert(root.left, sum);
        }
    }
}
