/**
 * @author yanliu
 * @create 2020-11-06-10:57
 */
public class BuildTreeFromInorderAndPostorder {
    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postOrder) {
            if (inorder == null || postOrder == null || inorder.length != postOrder.length) {
                return null;
            }

            return _helper(inorder, postOrder, 0, 0, inorder.length);
        }

        private TreeNode _helper(int[] inorder, int[] postOrder, int inorderStart, int postOrderStart, int size) {
            if (size == 0) {
                return null;
            }

            TreeNode root = new TreeNode(postOrder[postOrderStart + size - 1]);

            int inOrderRootIdx = inorderStart;

            while (inorder[inOrderRootIdx] != postOrder[postOrderStart + size - 1]) {
                inOrderRootIdx++;
            }

            int leftSize = inOrderRootIdx - inorderStart;
            int rightSize = size - leftSize -1;

            TreeNode leftNode = _helper(inorder, postOrder, inorderStart, postOrderStart, leftSize);
            TreeNode rightNode = _helper(inorder, postOrder, inOrderRootIdx+1,
                    postOrderStart+leftSize, rightSize);

            root.left = leftNode;
            root.right = rightNode;

            return root;


        }
    }
}
