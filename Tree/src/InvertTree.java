/**
 * @author yanliu
 * @create 2020-12-08-23:48
 */
public class InvertTree {
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            invertTree(root.left);

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertTree(root.right);

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        new Solution().invertTree(root);
    }
}
