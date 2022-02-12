import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2021-11-09-7:42 PM
 */
public class RecoverBinarySearchTree {
    static class Solution1 {
        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode x = null, y = null, pred = null;

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                if (pred != null && pred.val > curr.val) {
                    // record the last violation
                    y = curr;

                    if (x == null) {
                        // record the first violation
                        x = pred;

                    } else {
                        // the first violation is recorded
                        break;
                    }
                }

                pred = curr;
                curr = curr.right;
            }

            swap(x, y);
        }

        private void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    static class Solution2 {
        private TreeNode first, second, prev;

        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderRecover(root);

            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        private void inorderRecover(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderRecover(root.left);

            if (prev != null && root.val < prev.val) {
                second = root;

                if (first == null) {
                    first = prev;

                } else {
                    return;
                }
            }

            prev = root;

            inorderRecover(root.right);
        }
    }
}
