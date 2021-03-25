import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-03-24-22:59
 * LC111
 */
public class GetMinDepth {
    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int depth = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (curr.left == null && curr.right == null) {
                        return depth;
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }


            }

            return depth;

        }
    }
}
