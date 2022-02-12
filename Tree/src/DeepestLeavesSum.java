import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode1302
 * @author yanliu
 * @create 2021-12-23-10:12 PM
 */
public class DeepestLeavesSum {
    static class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int sum = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    sum += curr.val;

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }

                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
            }

            return sum;
        }
    }
}
