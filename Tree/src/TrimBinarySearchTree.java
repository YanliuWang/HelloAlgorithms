/**
 * LintCode 701
 * @author yanliu
 * @create 2021-04-11-12:29
 */
public class TrimBinarySearchTree {
    static class Solution {
        /**
         * @param root: given BST
         * @param minimum: the lower limit
         * @param maximum: the upper limit
         * @return: the root of the new tree
         */
        public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
            // write your code here
            if (root == null) {
                return null;
            }

            if (root.val >= minimum && root.val <= maximum) {
                root.left = trimBST(root.left, minimum, maximum);
                root.right = trimBST(root.right, minimum, maximum);

            } else if (root.val < minimum) {
                root = trimBST(root.right, minimum, maximum);

            } else {
                root = trimBST(root.left, minimum, maximum);

            }

            return root;
        }
    }
}
