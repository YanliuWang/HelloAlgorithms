/**
 * LC938
 * @author yanliu
 * @create 2021-04-07-8:45
 */
public class RangeSumBST {
    static class Solution1 {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }

            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }

            return root.val + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }

    static class Solution2 {
        private int res = 0;

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            dfs(root, low, high);

            return res;
        }

        private void dfs(TreeNode node, int low, int high) {
            if (node.val >= low && node.val <= high) {
                res += node.val;

                if (node.left != null) {
                    dfs(node.left, low, high);
                }

                if (node.right != null) {
                    dfs(node.right, low, high);
                }


            }

            if (node.val > high && node.left != null) {
                dfs(node.left, low, high);
            }

            if (node.val < low && node.right != null) {
                dfs(node.right, low, high);

            }

        }
    }
}
