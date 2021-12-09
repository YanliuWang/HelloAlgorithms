/**
 * find the parent of a given node in binary search tree
 * @author yanliu
 * @create 2021-11-13-10:42 AM
 */
public class FindParent {
    static class Solution {
        public TreeNode findParent(TreeNode root, int value) {
            if (root == null) {
                return null;
            }

            if (root.left != null && root.left.val == value
                    || root.right != null && root.right.val == value) {
                return root;
            }

            if (root.val > value) {
                return findParent(root.left, value);
            }

            if (root.val < value) {
                return findParent(root.right, value);
            }

            // cannot find the value
            return null;
        }
    }
}
