import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * LC101
 * @author yanliu
 * @create 2020-11-02-16:01
 */
public class IsSymmetric {
    static class Solution1 {
        /**
         * iteration
         *
         * @param root
         * @return whether the tree is symmetric or not
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            // for pushing null, we must use stack instead of deque
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root.left);
            stack.push(root.right);

            while (!stack.isEmpty()) {
                TreeNode n1 = stack.pop();
                TreeNode n2 = stack.pop();

                if (n1 == null && n2 == null) {
                    continue;
                }

                if (n1 == null || n2 == null || n1.val != n2.val) {
                    return false;
                }

                stack.push(n1.left);
                stack.push(n2.right);
                stack.push(n1.right);
                stack.push(n2.left);

            }

            return true;
        }
    }

    static class Solution2 {
        /**
         * recursion
         *
         * @param root
         * @return whether the tree is symmetric or not
         */
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetric(root.left, root.right);

        }

        /**
         * hyper-function is used to judge pair relationship
         * @param left
         * @param right
         * @return
         */
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val == right.val) {
                return isSymmetric(left.left, right.right)
                        && isSymmetric(left.right, right.left);
            } else {
                return false;
            }
        }

    }

    static class Solution3 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);

            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();

                if (node1 == null && node2 == null) {
                    continue;
                }

                if (node1 == null || node2 == null) {
                    return false;
                }

                if (node1.val != node2.val) {
                    return false;
                }

                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }

            return true;
        }
    }

}
