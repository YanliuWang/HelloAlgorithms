import java.sql.ResultSet;

/**
 * LintCode 578
 * @author yanliu
 * @create 2021-07-17-10:37
 */
public class LowestCommonAncestorIII {
    static class ResultType {
        boolean aExist, bExist;
        TreeNode ancestor;

        public ResultType(boolean aExist, boolean bExist, TreeNode ancestor) {
            this.aExist = aExist;
            this.bExist = bExist;
            this.ancestor = ancestor;
        }
    }

    /**
     * Node A or Node B may not exist in the tree
     */
    static class Solution {
        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
            ResultType LCA = getLowestCommonAncestor(root, A, B);

            return LCA.aExist && LCA.bExist ? LCA.ancestor : null;
        }

        private ResultType getLowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            if (root == null) {
                return new ResultType(false, false, null);
            }

            ResultType left = getLowestCommonAncestor(root.left, A, B);
            ResultType right = getLowestCommonAncestor(root.right, A, B);

            boolean aExist = left.aExist || right.aExist || root == A;
            boolean bExist = left.bExist || right.bExist || root == B;

            if (root == A || root == B) {
                return new ResultType(aExist, bExist, root);
            }

            if (left.ancestor != null && right.ancestor != null) {
                return new ResultType(aExist, bExist, root);
            }

            if (left.ancestor != null) {
                return new ResultType(aExist, bExist, left.ancestor);
            }

            if (right.ancestor != null) {
                return new ResultType(aExist, bExist, right.ancestor);
            }

            return new ResultType(aExist, bExist, null);

        }
    }
}
