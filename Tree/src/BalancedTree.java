/**
 * LeetCode 110
 * @author yanliu
 * @create 2021-01-01-12:13
 */
public class BalancedTree {
    static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        // return the height of the tree
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                // this tree is unbalanced
                // left or right sub tree is unbalanced
                // the height difference is too high
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }

    static class Solution2 {
        public class TreeNodeInfo {
            public int height;
            public boolean isBalanced;

            public TreeNodeInfo(int height, boolean isBalanced) {
                this.height = height;
                this.isBalanced = isBalanced;
            }
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            return divideAndConquer(root).isBalanced;

        }

        private TreeNodeInfo divideAndConquer(TreeNode root) {
            if (root == null) {
                return new TreeNodeInfo(0, true);
            }

            TreeNodeInfo left = divideAndConquer(root.left);
            TreeNodeInfo right = divideAndConquer(root.right);

            int height = Math.max(left.height, right.height) + 1;
            boolean isBalanced = true;

            if (!left.isBalanced || !right.isBalanced) {
                isBalanced = false;
            }

            if (Math.abs(left.height - right.height) > 1) {
                isBalanced = false;
            }

            return new TreeNodeInfo(height, isBalanced);

        }
    }

}
