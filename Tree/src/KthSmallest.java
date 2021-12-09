/**
 * LeetCode 230
 * @author yanliu
 * @create 2020-12-16-17:06
 */
public class KthSmallest {
    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int[] res = new int[1];

            inorder(root, k, new int[1], res);

            return res[0];
        }

        private void inorder(TreeNode root, int k, int[] rank, int[] res) {
            if (root == null) {
                return;
            }

            inorder(root.left, k, rank, res);

            rank[0]++;
            if (rank[0] == k) {
                res[0] = root.val;
                return;
            }

            inorder(root.right, k, rank, res);


        }
    }
}
