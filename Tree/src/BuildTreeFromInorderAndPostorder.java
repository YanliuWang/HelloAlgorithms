/**
 * LC106
 * @author yanliu
 * @create 2020-11-06-10:57
 */
public class BuildTreeFromInorderAndPostorder {
    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length) {
                return null;
            }

            int inStart = 0, inEnd = inorder.length - 1;
            int postStart = 0, postEnd = postorder.length - 1;

            return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
        }

        private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }

            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);

            int inOrderRootIdx = 0;

            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    inOrderRootIdx = i;
                }
            }

            root.left = buildTree(inorder, inStart, inOrderRootIdx - 1, postorder, postStart, postStart + inOrderRootIdx - (inStart + 1));
            root.right = buildTree(inorder, inOrderRootIdx + 1, inEnd, postorder, postStart + inOrderRootIdx - inStart, postEnd - 1);

            return root;
        }
    }
}
