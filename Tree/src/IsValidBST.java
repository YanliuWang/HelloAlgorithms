/**
 * LeetCode98
 * @author yanliu
 * @create 2021-11-11-10:26 AM
 */
public class IsValidBST {
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }

            if (min != null && root.val <= min.val) {
                return false;
            }

            if (max != null && root.val >= max.val) {
                return false;
            }

            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);


        }


    }
}
