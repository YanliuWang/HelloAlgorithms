import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 230
 * @author yanliu
 * @create 2020-12-16-17:06
 */
public class KthSmallestElementInBST {
    static class Solution1 {
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

    static class Solution2 {
        private int rank = 0;
        private int res = 0;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }

            rank = k;

            dfs(root);

            return res;
        }

        private void dfs(TreeNode root) {
            if (root.left != null) {
                dfs(root.left);
            }

            rank--;

            if (rank == 0) {
                res = root.val;
                return;
            }

            if (root.right != null) {
                dfs(root.right);
            }
        }
    }

    static class Solution3 {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();
                k--;

                if (k == 0) {
                    return curr.val;
                }

                curr = curr.right;

            }

            return -1;
        }
    }
}
