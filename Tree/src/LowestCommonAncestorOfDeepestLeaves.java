/**
 * LeetCode 1123
 * @author yanliu
 * @create 2021-11-13-1:51 PM
 */
public class LowestCommonAncestorOfDeepestLeaves {
    static class Solution {
        class ResultType {
            public TreeNode node;
            public int depth;

            public ResultType(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return getLCA(root, 0).node;
        }

        private ResultType getLCA(TreeNode root, int depth) {
            if (root == null) {
                return new ResultType(null, depth);
            }

            ResultType left = getLCA(root.left, depth + 1);
            ResultType right = getLCA(root.right, depth + 1);

            if (left.depth == right.depth) {
                return new ResultType(root, left.depth);
            }

            if (left.depth > right.depth) {
                return new ResultType(left.node, left.depth);
            }

            return new ResultType(right.node, right.depth);
        }
    }
}
