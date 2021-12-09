/**
 * LeetCode114 : Flatten Binary Tree to Linked List
 * @author yanliu
 * @create 2020-11-24-10:34
 */
public class FlattenBinaryTreeToLinkedList {
    static class Solution1 {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            flattenToLinkedList(root);
        }

        /**
         * 1. definition : flatten the tree to linked list and return the tail node
         *
         * @param root
         * @return
         */
        private TreeNode flattenToLinkedList(TreeNode root) {
            // 3. recursion exit
            if (root == null) {
                return null;
            }

            // 2. divide the main problem into sub problems
            TreeNode leftLast = flattenToLinkedList(root.left);
            TreeNode rightLast = flattenToLinkedList(root.right);


            if (root.left != null) {
                leftLast.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            // 3. recursion exit : return the last node
            if (rightLast != null) {
                return rightLast;

            }

            if (leftLast != null) {
                return leftLast;

            }

            return root;
        }
    }

    static class Solution2 {

    }
}
