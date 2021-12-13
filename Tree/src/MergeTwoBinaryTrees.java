import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode617
 * @author yanliu
 * @create 2021-12-12-4:38 PM
 */
public class MergeTwoBinaryTrees {
    static class Solution1 {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            TreeNode root = merge(root1, root2);

            return root;
        }

        private TreeNode merge(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }

            if (root1 == null) {
                return root2;
            }

            if (root2 == null) {
                return root1;
            }

            TreeNode root = new TreeNode(root1.val + root2.val);

            root.left = merge(root1.left, root2.left);
            root.right = merge(root1.right, root2.right);

            return root;

        }
    }

    static class Solution2 {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }

            if (root1 == null) {
                return root2;
            }

            if (root2 == null) {
                return root1;
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();

            TreeNode root = new TreeNode(root1.val + root2.val);

            queue.offer(root);
            queue1.offer(root1);
            queue2.offer(root2);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
                TreeNode left1 = node1.left, left2 = node2.left;
                TreeNode right1 = node1.right, right2 = node2.right;

                if (left1 != null || left2 != null) {
                    if (left1 != null && left2 != null) {
                        TreeNode left = new TreeNode(left1.val + left2.val);
                        node.left = left;
                        queue.offer(left);
                        queue1.offer(left1);
                        queue2.offer(left2);
                    } else if (left1 != null) {
                        node.left = left1;
                    } else if (left2 != null) {
                        node.left = left2;
                    }
                }

                if (right1 != null || right2 != null) {
                    if (right1 != null && right2 != null) {
                        TreeNode right = new TreeNode(right1.val + right2.val);
                        node.right = right;
                        queue.offer(right);
                        queue1.offer(right1);
                        queue2.offer(right2);
                    } else if (right1 != null) {
                        node.right = right1;
                    } else if (right2 != null) {
                        node.right = right2;
                    }
                }

            }

            return root;

        }
    }
}
