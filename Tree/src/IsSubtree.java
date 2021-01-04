/**
 * LC572
 * @author yanliu
 * @create 2021-01-04-10:28
 */
public class IsSubtree {
    static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }

            if (isSameTree(s, t)) {
                return true;
            }

            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }

            if (s == null || t == null) {
                return false;
            }

            if (s.val != t.val) {
                return false;
            }

            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
