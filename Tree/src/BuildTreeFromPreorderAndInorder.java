/**
 * LC105
 * @author yanliu
 * @create 2020-11-08-21:56
 */
public class BuildTreeFromPreorderAndInorder {
    static class Solution {
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                if (preorder == null || inorder == null || preorder.length != inorder.length) {
                    return null;
                }

                int preStart = 0, preEnd = preorder.length - 1;
                int inStart = 0, inEnd = inorder.length - 1;

                return buildTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
            }

            private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
                if (preStart > preEnd || inStart > inEnd) {
                    return null;
                }

                int rootVal = preorder[preStart];
                TreeNode root = new TreeNode(rootVal);

                int inorderRootIdx = 0;
                for (int i = inStart; i <= inEnd; i++) {
                    if (inorder[i] == rootVal) {
                        inorderRootIdx = i;
                        break;
                    }
                }

                root.left = buildTree(preorder, preStart + 1, preStart + inorderRootIdx - inStart, inorder, inStart, inorderRootIdx - 1);
                root.right = buildTree(preorder, preStart + inorderRootIdx - inStart + 1, preEnd, inorder, inorderRootIdx + 1, inEnd);

                return root;

            }
        }
    }
}
