/**
 * @author yanliu
 * @create 2021-01-25-20:52
 */
public class DiameterOfBinaryTree {
    public class Solution {
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
}
