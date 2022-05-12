/**
 * LeetCode226
 * @author yanliu
 * @create 2020-12-08-23:48
 */
public class InvertTree {
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
        }
    }

    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            traverse(root);

            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            traverse(root.left);
            traverse(root.right);
        }
    }

}
