/**
 * @author yanliu
 * @create 2020-11-24-10:34
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // record left and right subTree
        TreeNode left = root.left;
        TreeNode right = root.right;

        // set the left to null
        root.left = null;

        // connect the flattened left subTree to the right
        root.right = left;

        // connect the flatten right subTree to the right
        TreeNode curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = right;

    }
}
