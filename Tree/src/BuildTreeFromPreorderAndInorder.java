/**
 * @author yanliu
 * @create 2020-11-08-21:56
 */
public class BuildTreeFromPreorderAndInorder {
    static class Solution {
        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
                return null;
            }

            return _helper(preOrder, inOrder, 0, 0, preOrder.length);
        }

        private TreeNode _helper(int[] preOrder, int[] inOrder,
                                 int preOrderStart, int inOrderStart, int size) {
            if (size == 0) {
                return null;
            }

            int inorderRootIdx = inOrderStart;

            while (inOrder[inorderRootIdx] != preOrder[preOrderStart]) {
                inorderRootIdx++;
            }

            int leftSize = inorderRootIdx - inOrderStart;
            int rightSize = size - leftSize - 1;

            TreeNode root = new TreeNode(preOrder[preOrderStart]);

            root.left = _helper(preOrder, inOrder,
                    preOrderStart+1, inOrderStart, leftSize);
            root.right = _helper(preOrder, inOrder,
                    preOrderStart+leftSize+1, inorderRootIdx+1, rightSize);

            return root;

        }
    }
}
