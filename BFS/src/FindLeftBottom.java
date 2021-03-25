import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yanliu
 * @create 2021-03-24-23:12
 */
public class FindLeftBottom {
    static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            // judge whether the current node is the first node
            boolean isFirst = false;
            Queue<TreeNode> queue = new LinkedList<>();
            int leftValue = 0;

            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                isFirst = true;

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (isFirst) {
                        leftValue = curr.val;
                        isFirst = false;
                    }

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }

            }

            return leftValue;
        }
    }
}
