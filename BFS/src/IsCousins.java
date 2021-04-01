import java.util.LinkedList;
import java.util.Queue;

/**
 * LC993
 * @author yanliu
 * @create 2021-04-01-14:10
 */
public class IsCousins {
    static class Solution1 {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean xExist = false;
            boolean yExist = false;

            while (!queue.isEmpty()) {
                int size = queue.size();
                xExist = false;
                yExist = false;

                for (int i = 0; i < size; i++) {
                    TreeNode top = queue.poll();

                    if (top.val == x) {
                        xExist = true;
                    }

                    if (top.val == y) {
                        yExist = true;
                    }

                    if (top.left != null && top.right != null) {
                        if (top.left.val == x && top.right.val == y) {
                            return false;
                        }

                        if (top.right.val == x && top.left.val == y) {
                            return false;
                        }
                    }

                    if (top.left != null) {
                        queue.offer(top.left);
                    }

                    if (top.right != null) {
                        queue.offer(top.right);
                    }
                }

                if (xExist == true && yExist == true) {
                    return true;
                }
            }

            return false;
        }
    }

    static class Solution2 {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }

            int[] depthX = new int[1];
            int[] depthY = new int[1];

            TreeNode parentX = getParent(root, x, depthX);
            TreeNode parentY = getParent(root, y, depthY);

            if (parentX != parentY && depthX[0] == depthY[0]) {
                return true;
            }

            return false;
        }

        private TreeNode getParent(TreeNode root, int value, int[] depth) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                depth[0]++;

                for (int i = 0; i < size; i++) {
                    TreeNode top = queue.poll();

                    if (top.left != null) {
                        if (top.left.val == value) {
                            return top;
                        }

                        queue.offer(top.left);
                    }

                    if (top.right != null) {
                        if (top.right.val == value) {
                            return top;
                        }

                        queue.offer(top.right);
                    }

                }
            }

            return null;
        }
    }
}
