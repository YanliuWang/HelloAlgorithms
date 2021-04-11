/**LintCode 701
 * @author yanliu
 * @create 2021-04-11-12:29
 */
public class TrimBinarySearchTree {
    class Solution {
        /**
         * @param root: given BST
         * @param minimum: the lower limit
         * @param maximum: the upper limit
         * @return: the root of the new tree
         */
        public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
            if (root == null) {
                return null;
            }

            if (root.val < minimum) {
                return trimBST(root.right, minimum, maximum);
            } else if (root.val > maximum) {
                return trimBST(root.left, minimum, maximum);
            }

            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);

            return root;

        }
    }
}
