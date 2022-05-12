/**
 * LeetCode572
 * @author yanliu
 * @create 2021-12-25-5:18 PM
 */
public class SubtreeOfAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return subRoot == null;
            }

            if (isSame(root, subRoot)) {
                return true;
            }

            return isSubtree(root.left, subRoot)
                    || isSubtree(root.right, subRoot);
        }

        private boolean isSame(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null) {
                return false;
            }

            if (root1.val != root2.val) {
                return false;
            }

            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
    }
}
