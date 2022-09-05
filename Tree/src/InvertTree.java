import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode226
 * @author yanliu
 * @create 2020-12-08-23:48
 */
public class InvertTree {
    static class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
        }
    }

    static class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            traverse(root);

            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            traverse(root.left);
            traverse(root.right);
        }
    }

    static class Solution3 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;

            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                curr = stack.pop();

                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;

                curr = curr.left;
            }

            return root;
        }
    }

}
