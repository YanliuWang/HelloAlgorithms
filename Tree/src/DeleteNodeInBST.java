/**
 * @author yanliu
 * @create 2021-11-11-10:48 AM
 */
public class DeleteNodeInBST {
    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (key < root.val) {
                root.left = deleteNode(root.left, key);

            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);

            } else {
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                // the deleted node has two children
                TreeNode leftMax = findMax(root.left);
                root.val = leftMax.val;

                root.left = deleteNode(root.left, leftMax.val);
            }

            return root;

        }

        private TreeNode findMax(TreeNode node) {
            TreeNode curr = node;

            while (curr.right != null) {
                curr = curr.right;
            }

            return curr;
        }
    }
}
