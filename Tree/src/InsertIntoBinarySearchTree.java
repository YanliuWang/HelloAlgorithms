/**
 * LeetCode 701
 * @author yanliu
 * @create 2021-11-02-10:18 PM
 */
public class InsertIntoBinarySearchTree {
    static class Solution1 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }

    static class Solution2 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode parent = null;
            TreeNode curr = root;

            boolean isLeft = true;

            while (curr != null) {
                parent = curr;

                if (val < curr.val) {
                    curr = curr.left;
                    isLeft = true;

                } else {
                    curr = curr.right;
                    isLeft = false;

                }
            }

            if (isLeft) {
                parent.left = new TreeNode(val);
            } else {
                parent.right = new TreeNode(val);
            }

            return root;
        }
    }

    static class Solution3 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode curr = root;

            while (curr != null) {
                if (val > curr.val) {
                    if (curr.right == null) {
                        curr.right = new TreeNode(val);
                        return root;
                    }

                    curr = curr.right;

                } else {
                    if (curr.left == null) {
                        curr.left = new TreeNode(val);
                        return root;
                    }

                    curr = curr.left;
                }
            }

            return root;
        }
    }
}
