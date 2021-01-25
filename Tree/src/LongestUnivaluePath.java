/**
 * LC687
 * @author yanliu
 * @create 2021-01-25-20:58
 */
public class LongestUnivaluePath {
    static class Solution {
        private int res = 0;

        public int longestPath(TreeNode root) {
            getLongestPath(root);

            return res;
        }

        private int getLongestPath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int L = getLongestPath(root.left);
            int R = getLongestPath(root.right);

            int pathL = 0;
            int pathR = 0;

            if (root.left != null && root.left.val == root.val) {
                pathL = L;
            }

            if (root.right != null && root.right.val == root.val) {
                pathR = R;
            }

            res = Math.max(res, pathL + pathR);

            return Math.max(pathL, pathR) + 1;
        }
    }
}
