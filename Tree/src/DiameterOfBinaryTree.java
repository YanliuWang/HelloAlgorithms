/**
 * LeetCode543
 * @author yanliu
 * @create 2021-01-25-20:52
 */
public class DiameterOfBinaryTree {
    class Solution1 {
        /**
         * @param root: a root of binary tree
         * @return: return a integer
         */
        public int diameterOfBinaryTree(TreeNode root) {
            // write your code here
            return DFS(root)[0];

        }

        // get the TreeNode int[0] max diameter and int[1] max chain
        private int[] DFS(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }

            int[] left = DFS(root.left);
            int[] right = DFS(root.right);

            // get the left max diameter or right max diameter or get the max chain
            int maxDiameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);
            int maxChain = 1 + Math.max(left[1], right[1]);

            return new int[]{maxDiameter, maxChain};
        }
    }

    class Solution2 {
        private int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            dfs(root);

            return res;
        }

        /**
         * return the length of path from current node to leaf
         * @param root
         * @return
         */
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            res = Math.max(res, left + right);

            return Math.max(left, right) + 1;
        }
    }
}
