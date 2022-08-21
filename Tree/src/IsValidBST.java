import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode98
 * @author yanliu
 * @create 2021-11-11-10:26 AM
 */
public class IsValidBST {
    static class Solution1 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }

            if (min != null && root.val <= min.val) {
                return false;
            }

            if (max != null && root.val >= max.val) {
                return false;
            }

            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);


        }


    }

    static class Solution2 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;
            Integer prev = null;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                if (prev != null && curr.val <= prev) {
                    return false;
                }

                prev = curr.val;
                curr = curr.right;
            }

            return true;
        }
    }

    static class Solution3 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }

            if (node.val <= min || node.val >= max) {
                return false;
            }

            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
    }
}
