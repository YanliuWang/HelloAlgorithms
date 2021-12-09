import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2021-11-09-7:42 PM
 */
public class RecoverBinarySearchTree {
    class Solution {
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
                    // find the two swapped nodes
                    y = curr;

                    if (x == null) {
                        // assign the x node to pred
                        x = pred;

                    } else {
                        // x is already assigned to pred
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
}
